import React, {Component} from "react";
import SubscriberDataService from "./SubscriberDataService";

class SubscribersListComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            subscribers: [],
            message: null
        }
        this.deleteSubscriberClicked = this.deleteSubscriberClicked.bind(this)
        this.updateSubscriberClicked = this.updateSubscriberClicked.bind(this)
        this.addCourseClicked = this.addCourseClicked.bind(this)
        this.refreshCourses = this.refreshCourses.bind(this)
    }

    componentDidMount() {
        this.refreshCourses();
    }

    refreshCourses() {
        SubscriberDataService.retrieveAllSubscribers()
            .then(
                response => {
                    console.log(response);
                    this.setState({subscribers: response.data})
                }
            )
    }

    deleteSubscriberClicked(id) {
        SubscriberDataService.deleteSubscriber(id)
            .then(
                response => {
                    this.setState({ message: `Delete of subscriber ${id} Successful` })
                    this.refreshCourses()
                }
            )

    }

    updateSubscriberClicked(id) {
        console.log('update ' + id)
        this.props.history.push(`/subscribers/${id}`)
    }

    addCourseClicked() {
        this.props.history.push(`/subscribers/-1`)
    }

    render() {
        return (
            <div className="container">
                <h3>All Subscribers</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.subscribers.map(
                                subscriber =>
                                    <tr key={subscriber.id}>
                                        <td>{subscriber.id}</td>
                                        <td>{subscriber.name}</td>
                                        <td>{subscriber.desc}</td>
                                        <td><button className="btn btn-warning" onClick={() => this.deleteSubscriberClicked(subscriber.id)}>Delete</button></td>
                                        <td><button className="btn btn-success" onClick={() => this.updateSubscriberClicked(subscriber.id)}>Update</button></td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addCourseClicked}>Add2</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default SubscribersListComponent;