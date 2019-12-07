import React, { Component } from 'react'
import AuthenticationService from './AuthenticationService'
import AppNavbar from '../AppNavbar'

class LogoutComponent extends Component {
    
    render() {
        AuthenticationService.logout()
        return (
            <>
            <AppNavbar/>
                <h1>You are logged out</h1>
                <div className="container">
                </div>

            </>
        )
    }
}

export default LogoutComponent