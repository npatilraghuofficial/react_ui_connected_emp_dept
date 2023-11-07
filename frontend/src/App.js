import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import { AppProvider } from './Context/Context';

import RegisterPage from './Views/Employee/RegisterPage';
import RegisterDept from './Views/Department/RegisterDept';
import GetAllDept from './Views/Department/GetAllDept';
import UpdateDeptById from './Views/Department/UpdateDeptById';


function App() {
  return (
    <>
      <Router>
        <AppProvider>
          <Routes>

            <Route path="/registeremp" element={<RegisterPage />} />

            <Route path="/registerdept" element={<RegisterDept />} />
            {/* <Route path="/getalldeptbyid" element={<GetAllDeptById />} /> */}
            <Route path="/getalldept" element={<GetAllDept />}/>
            {/* UpdateDeptById */}

            <Route path="/updatedeptbyid" element={<UpdateDeptById />} />
          </Routes>
        </AppProvider>



      </Router>
    </>
  );
}

export default App;
