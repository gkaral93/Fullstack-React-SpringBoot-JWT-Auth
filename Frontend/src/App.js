import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import BundleList from './components/BundleList';
import BundleEdit from './components/BundleEdit';
import LoginComponent from './components/LoginComponent';
import AuthenticatedRoute from './components/AuthenticatedRoute.jsx';
import LogoutComponent from './components/LogoutComponent';

class App extends Component {
  render() {
    return (
      <Router>  
      
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          < AuthenticatedRoute path='/bundles/:id' component={BundleEdit}/>
          < Route path="/login" exact component={LoginComponent} />
          < Route path="/logout" exact component={LogoutComponent} />
          <AuthenticatedRoute Route path="/bundles" exact component={BundleList} />
        </Switch>
      
      </Router>
    )
  }
}
export default App;