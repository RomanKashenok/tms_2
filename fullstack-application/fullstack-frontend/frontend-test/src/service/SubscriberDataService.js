import axios from 'axios'

export const APP_API_URL = `http://localhost:9090`;
const SUBSCRIBER_API_URL = `${APP_API_URL}/subscribers`;
const SUBSCRIBER_API_URL_SEARCH = `${SUBSCRIBER_API_URL}/search}`;


class SubscriberDataService {

    retrieveAllSubscribers() {
        return axios.get(`${SUBSCRIBER_API_URL}`);
    }

    retrieveSubscribersByName(name) {
        return axios.get(`${SUBSCRIBER_API_URL_SEARCH}/${name}`);
    }

    retrieveSubscriber(id) {
        return axios.get(`${SUBSCRIBER_API_URL}/${id}`);
    }

    deleteSubscriber(id) {
        return axios.delete(`${SUBSCRIBER_API_URL}/${id}`);
    }

    createSubscriber(user) {
        return axios.post(`${SUBSCRIBER_API_URL}`, user)};

    updateSubscriber(id, user) {
        return axios.put(`${SUBSCRIBER_API_URL}`, user);
    }
}

export default new SubscriberDataService()