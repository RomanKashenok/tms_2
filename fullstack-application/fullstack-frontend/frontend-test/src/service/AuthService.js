import axios from 'axios'
import {APP_API_URL} from "./SubscriberDataService";

export const USER_SESSION_USERNAME = 'username';



class AuthService{

    userLoggedIn = false;

    authenticate(username, password) {
        return axios.get(`${APP_API_URL}/auth`,
            { headers: { authorization: this.createBasicAuthToken(username, password)}}
        );
    }

    createBasicAuthToken(username, password) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }


    registerLoggedInUser(username, password) {
        this.userLoggedIn = true
        sessionStorage.setItem(USER_SESSION_USERNAME, username);
        this.setUpAxisInterceptor(this.createBasicAuthToken(username, password))
    }

    setUpAxisInterceptor(token) {
        axios.interceptors.request.use(
            (config) => {
                if(this.userLoggedIn) {
                    config.headers.authorization = token
                }
                return config
            }
        )
    }
}

export default new AuthService()