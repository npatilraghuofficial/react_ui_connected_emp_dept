import React from 'react';
import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBCardImage,
    MDBInput,
    MDBIcon,
    MDBCheckbox
}
    from 'mdb-react-ui-kit';
import myImage from '../../assets/logo_.png';
import { NavLink } from 'react-router-dom';


import { useAppContext } from '../../Context/Context';
import NavBar from '../../Components/NavBar';

function RegisterPage() {


    const { state, dispatch } = useAppContext();

    const handleNameChange = (e) => {
        // alert(e.target.value);
        // alert(state.name);
      dispatch({ type: 'SET_empName', payload: e.target.value });
    };
  
    const handleEmailChange = (e) => {
        // alert(e.target.value);
        // alert(state.email);
      dispatch({ type: 'SET_empEmail', payload: e.target.value });
    };
  
    const handleSalaryChange = (e) => {
        // alert(e.target.value);
        // alert(state.salary);
      dispatch({ type: 'SET_empSal', payload: e.target.value });
    };
  
    const handleAddressChange = (e) => {

        // alert(e.target.value);
        // alert(state.address);
      dispatch({ type: 'SET_empAddress', payload: e.target.value });
    };
  
    const handleDepartmentChange = (e) => {
        // alert(e.target.value);
        // alert(state.department);
      dispatch({ type: 'SET_deptId', payload: e.target.value });
    };




    const handleSubmit = async () => {
        console.log(state);
        alert("handleSubmit");


        // const { state } = useAppContext();

        try {
            const URL='http://localhost:9090/api/employee/';
            
          const response = await fetch(URL, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(state), // Send the form data as JSON
          });
    
          if (response.ok) {
            // Handle a successful response from the server
            console.log('Data sent successfully');
            console.log(state);
            console.log(response);

          } else {
            // Handle errors from the server
            console.error('Error sending data to the server');
          }
        } catch (error) {
          console.error('An error occurred while sending data:', error);
        }
      };


    return (
      <>
              <NavBar></NavBar>

    
        <MDBContainer fluid>
        <NavLink to="/registerdept">   <button type="button" class="btn btn-danger" >Go To Department form</button></NavLink>

        <NavLink to="/getallemp">   <button type="button" class="btn btn-info" >Get All Emp</button></NavLink>
        <NavLink to="/updateempbyid">   <button type="button" class="btn btn-info" >Update Emp By Id</button></NavLink>
        <NavLink to="/deleteempbyid">   <button type="button" class="btn btn-info" >DeleteEmpById</button></NavLink>
        <NavLink to="/getempbydeptid">   <button type="button" class="btn btn-info" >DeleteEmpById</button></NavLink>




            <MDBCard className='text-black m-5' style={{ borderRadius: '25px' }}>
                <MDBCardBody>
                    <MDBRow>
                        <MDBCol md='10' lg='6' className='order-2 order-lg-1 d-flex flex-column align-items-center'>

                            <span className="h1 fw-bold mb-0">Register Employee</span>
                            <br></br>





                            <div className="d-flex flex-row align-items-center mb-4">
                                <MDBIcon fas icon="envelope me-3" size='lg' />
                                <MDBInput label='Name' id='form2' type='text' value={state.name} onChange={handleNameChange}
/>
                            </div>



                            <div className="d-flex flex-row align-items-center mb-4">
                                <MDBIcon fas icon="envelope me-3" size='lg' />
                                <MDBInput label='Email' type='email' value={state.email} onChange={handleEmailChange}
/>
                            </div>


                            <div className="d-flex flex-row align-items-center mb-4">
                                <MDBIcon fas icon="envelope me-3" size='lg' />
                                <MDBInput label='Salary'  type='number' value={state.salary} onChange={handleSalaryChange}
/>
                            </div>



                            

                            <div class="form-outline mb-4">
                                <textarea class="form-control" id="form7Example7" rows="4" value={state.address} onChange={handleAddressChange}></textarea>
                                <label class="form-label" for="form7Example7">Address</label>
                            </div>

                            <div className="d-flex flex-row align-items-center mb-4 ">
                            <label class="form-label" for="form7Example7">Department</label>

                                <MDBIcon fas icon="user me-4" size='lg' 
/>
                                <select className="select form-control" value={state.department} onChange={handleDepartmentChange} >
                                    <option value="-1">Select</option>
                                    <option value="1">IT</option>

                                    <option value="2">HR</option>
                                    <option value="3">Sales</option>
                                    <option value="4">Finance</option>
                                    <option value="5">Marketing</option>

                                </select>

                            </div>



<button type="button" class="btn btn-success" onClick={handleSubmit}>Register</button>


                        </MDBCol>

                        <MDBCol md='10' lg='6' className='order-1 order-lg-2 d-flex align-items-center'>
                            <MDBCardImage src={myImage} fluid />

                        </MDBCol>

                    </MDBRow>
                </MDBCardBody>
            </MDBCard>

        </MDBContainer>

        
        </>
    );
   
}

export default RegisterPage;