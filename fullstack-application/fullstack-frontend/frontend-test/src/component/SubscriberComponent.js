import React, {Component} from "react";
import {ErrorMessage, Field, Form, Formik} from 'formik';
import SubscriberDataService from "../service/SubscriberDataService";

class SubscriberComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            user: {
                id: '',
                name: '',
                username: '',
                password: '',
                desc: ''
            }
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount() {
        console.log(this.state.id)
        if (this.state.id != -1) {
            SubscriberDataService.retrieveSubscriber(this.state.id)
                .then(response => this.setState({
                    user: response.data
                }))
        } else {
            return
        }
    }

    validate(values) {
        let errors = {}
        if (!values.user.desc) {
            errors.desc = 'Enter a Description'
        } else if (values.user.desc.length < 5) {
            errors.desc = 'Enter atleast 5 Characters in Description'
        }

        if (!values.user.name) {
            errors.name = 'Enter subscriber name'

            return errors

        }
    }

    onSubmit(values) {
        let user = {
            id: this.state.id == -1 ? null : values.user.id,
            desc: values.user.desc,
            name: values.user.name,
            username: values.user.username,
            password: values.user.password
        };

        if (this.state.id == -1) {
            SubscriberDataService.createSubscriber(user)
                .then(() => this.props.history.push('/subscribers'))
        } else {
            SubscriberDataService.updateSubscriber(this.state.id, user)
                .then(() => this.props.history.push('/subscribers'))
        }

        console.log(values);
    }

    render() {

        let {user} = this.state

        return (
            <div>
                <h3>Course</h3>
                <div className="container">
                    <Formik
                        initialValues={{user}}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="desc" component="div" className="alert alert-warning"/>
                                    <ErrorMessage name="name" component="div" className="alert alert-warning"/>

                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="user.id" disabled/>
                                    </fieldset>

                                    <fieldset className="form-group">
                                        <label>Name</label>
                                        <Field className="form-control" type="text" name="user.name" placeholder='Enter name'/>
                                    </fieldset>

                                    <fieldset className="form-group">
                                        <label>Username</label>
                                        <Field className="form-control" type="text" name="user.username" placeholder='Enter username'/>
                                    </fieldset>

                                    <fieldset className="form-group">
                                        <label>Password</label>
                                        <Field className="form-control" type="text" name="user.password" placeholder='Enter password'/>
                                    </fieldset>

                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="user.desc" placeholder='Enter description'/>
                                    </fieldset>

                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        )
    }
}

export default SubscriberComponent