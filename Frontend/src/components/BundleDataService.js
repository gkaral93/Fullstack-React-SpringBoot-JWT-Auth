import axios from 'axios'

const API_URL = 'http://localhost:8080/api'

class BundleDataService {
    retrieveBundles() {
        console.log('executed service')
        return axios.get(`${API_URL}/bundles`,
        { Headers:{authorization: 'Bearer ' + sessionStorage.getItem('token')}});
    }
}
export default new BundleDataService()