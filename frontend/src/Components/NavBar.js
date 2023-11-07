import React, { useState } from 'react';
import {
  MDBContainer,
  MDBNavbar,
  MDBNavbarBrand,
  MDBNavbarToggler,
  MDBIcon,
  MDBNavbarNav,
  MDBNavbarItem,
  MDBNavbarLink,

  MDBCollapse,
} from 'mdb-react-ui-kit';



export default function NavBar() {
  const [showBasic, setShowBasic] = useState(false);

  return (
    <MDBNavbar expand='lg' light bgColor='light'>
      <MDBContainer fluid>
        <MDBNavbarBrand href='#'>RNP-Store</MDBNavbarBrand>

        <MDBNavbarToggler
          aria-controls='navbarSupportedContent'
          aria-expanded='false'
          aria-label='Toggle navigation'
          onClick={() => setShowBasic(!showBasic)}
        >
          <MDBIcon icon='bars' fas />
        </MDBNavbarToggler>

        <MDBCollapse navbar show={showBasic}>
          <MDBNavbarNav className='mr-auto mb-2 mb-lg-0'>
            <MDBNavbarItem>
              <MDBNavbarLink active aria-current='page' href='#'>
                Home
              </MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink href='#'>Link</MDBNavbarLink>
            </MDBNavbarItem>

            

            <MDBNavbarItem>
              <MDBNavbarLink disabled href='#' tabIndex={-1} aria-disabled='true'>
                Disabled
              </MDBNavbarLink>
            </MDBNavbarItem>
            
           

          </MDBNavbarNav>

          {/* <form className='d-flex input-group w-auto'>
            
            <input type='search' className='form-control' placeholder='Type query' aria-label='Search' />
            <MDBBtn color='primary'>Search</MDBBtn>
          </form> */}
        </MDBCollapse>

        

&nbsp;&nbsp;
<MDBIcon icon="shopping-cart" /> &nbsp;<span>Cart</span><sup> </sup> &nbsp;&nbsp;&nbsp;&nbsp;


             <MDBIcon icon="bell" /> &nbsp;<span>Notification</span><sup></sup> &nbsp;&nbsp;&nbsp;&nbsp;

            {/* //add orders label */} 
            <MDBIcon icon="shopping-bag" />&nbsp;<span>Orders</span><sup> </sup>  &nbsp;&nbsp;&nbsp;&nbsp;
            <MDBIcon icon="user"/>  &nbsp;<span>Profile </span>&nbsp;&nbsp;&nbsp;&nbsp;
            <MDBIcon icon="gear"/>  &nbsp;<span>Settings</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <MDBIcon icon="sign-out-alt"/  > &nbsp; <span>Logout</span> &nbsp;&nbsp;&nbsp;&nbsp;


      </MDBContainer>

      
    </MDBNavbar>
  );
}
