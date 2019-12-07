import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';
import BundleDataService from './BundleDataService'
import AuthenticationService from './AuthenticationService'
import axios from 'axios'

class BundleList extends Component {

  constructor(props) {
    super(props);
    this.state = {bundles: [], isLoading: true};
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    this.setState({isLoading: true});
    if (AuthenticationService.isUserLoggedIn()) {
    BundleDataService.retrieveBundles().then(response => {this.setState({bundles: response.data, isLoading: false})})
    }
  }
 
  async remove(id) {
     axios(`/api/deleteBundle/${id}`, {
     method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'

     }}
     )
    .then(() => {
      let updatedBundles = [...this.state.bundles].filter(i => i.id !== id);
      this.setState({bundles: updatedBundles});
    });
  }
  
  render() {
    const {bundles, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const bundleList = bundles.map(bundle => {

      return <tr key={bundle.id}>
        <td style={{whiteSpace: 'nowrap'}}>{bundle.name}</td>
        <td style={{whiteSpace: 'nowrap'}}>{bundle.price}</td>
        <td style={{whiteSpace: 'nowrap'}}>{bundle.code}</td>
        <td style={{whiteSpace: 'nowrap'}}>{bundle.expdate}</td>
        <td style={{whiteSpace: 'nowrap'}}>{bundle.avadate}</td>

        <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/bundles/" + bundle.id}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => this.remove(bundle.id)}>Delete</Button>
          </ButtonGroup>
        </td>
      </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/bundles/new">  Add Service Bundle </Button>
          </div>
      
          <h3>Services Bundles  </h3>
          <Table className="mt-4">
            <thead>
            <tr>
              <th >Name</th>
              <th >Price</th>
              <th>Code</th>
              <th >Expiration date</th>
              <th>Available date</th>
              <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {bundleList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default BundleList;