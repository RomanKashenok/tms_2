import {Component} from "react";
import React from "react";
import {PASSWORD, USER} from "../service/SubscriberDataService";
import AuthService from "../service/AuthService";

class LoginComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            password: '',
            failed: false,
            success: false
        }

        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)

    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    loginClicked() {
        AuthService.authenticate(this.state.username, this.state.password)
            .then(() => {
                AuthService.registerLoggedInUser(this.state.username, this.state.password)

                this.setState({success: true})
                this.setState({failed: false})

                setTimeout(function() {
                    this.props.history.push("/subscribers")
                }.bind(this), 2000)
                // this.props.history.push(`/subscribers`)
            }).catch(() => {
            this.setState({success: false})
            this.setState({failed: true})
        })
    }

    render() {
        return (
            <div>
                <h1>Login form</h1>
                <div className="container">
                    {this.state.failed && <div className="alert alert-danger"><h3> Invalid credentials </h3></div>}
                    {this.state.success && <div className="alert alert-success"><h3> Log in successful </h3></div>}

                    User name: <input type="text" name="username" value={this.state.username} onChange={this.handleChange}/>
                    Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange}/>

                    <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
                </div>
            </div>
        )
    }
}

export default LoginComponent