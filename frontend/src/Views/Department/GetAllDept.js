import React, { useEffect, useState } from 'react';
import { MDBTable, MDBTableHead, MDBTableBody } from 'mdb-react-ui-kit';
import { NavLink } from 'react-router-dom';
function DepartmentList() {
  const [departments, setDepartments] = useState([]);

  useEffect(() => {
    // Fetch the list of departments from your API here
    // Replace 'your-api-endpoint' with the actual endpoint to fetch departments
    const URL = "http://localhost:9090/api/department/all";
    fetch(URL)
      .then((response) => response.json())
      .then((data) => setDepartments(data))
      .catch((error) => console.error('Error fetching departments:', error));
  }, []);

  const handleUpdate = async (id,deptName) => {
    // Write code here to update a department
    // alert(id);
    sessionStorage.clear();
    sessionStorage.setItem("UpdatabledeptId",id);
    
  }


  const handleDeleteDeptById = async (id) => {
    // Write code here to delete a department
    // alert(id);
   const answer = window.confirm("Are you sure you want to delete this department?");

sessionStorage.clear();
sessionStorage.setItem("UpdatabledeptId",id);
    if(answer) {

        // Write code here to delete a department
        // alert(id);
        const requiredDeptId=JSON.parse(sessionStorage.getItem("UpdatabledeptId")); 

        const URL = `http://localhost:9090/api/department/${requiredDeptId}`;
        fetch(URL, {
            method: 'DELETE',
        })
            .then((response) => response.json())
            .then((data) => {
            if (data) {
                console.log('Department deleted successfully');
                console.log(data);
                alert("Department deleted successfully");
            } else {
                console.error('Department data not found');
            }
            })
            .catch((error) => console.error('Error deleting departments:', error));
        }
        else {
            alert("Department not deleted");
            alert("Department not deleted");
        }
    sessionStorage.clear();
  }


  return (
    <div>
      <h1>Department List</h1>
      <MDBTable>
        <MDBTableHead>
          <tr>
            <th>Department ID</th>
            <th>Department Name</th>
          </tr>
        </MDBTableHead>
        <MDBTableBody>
          {departments.map((department) => (
            <tr key={department.id}>
              <td>{department.id}</td>
              <td>{department.deptName}</td>
              <td><NavLink to="/updatedeptbyid" >   <button type="button" class="btn btn-primary" onClick={(e) => handleUpdate(department.id,department.deptName)}
>Update </button></NavLink>
</td>

<td><NavLink to="/deletedeptbyid">   <button type="button" class="btn btn-danger" onClick={(e) => handleDeleteDeptById(department.id)} >Delete </button></NavLink>
</td>
            </tr>
          ))}
        </MDBTableBody>
      </MDBTable>
    </div>
  );
}

export default DepartmentList;
