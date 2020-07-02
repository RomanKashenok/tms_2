import React, {Component} from 'react';
import SubscribersListComponent from "./SubscribersListComponent";
import SubscriberComponent from "./SubscriberComponent";
import {BrowserRouter, Route, Switch} from "react-router-dom";

class SubscriberApp extends Component {
    render() {
        return (
            <BrowserRouter>
                <h1>Subscribers app</h1>
                <Switch>
                    <Route path="/" exact component={SubscribersListComponent}/>
                    <Route path="/subscribers" exact component={SubscribersListComponent}/>
                    <Route path="/subscribers/:id" component={SubscriberComponent}/>
                </Switch>
            </BrowserRouter>
        )
    }
}

export default SubscriberApp