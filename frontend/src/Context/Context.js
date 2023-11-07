// Create a context.js file

import { createContext, useContext, useReducer } from 'react';

const AppContext = createContext();
const AppContextDept = createContext(); // Add a new context for department data

const initialState = {
  // Define your initial state here
  empName: '',
  empEmail: '',
  empSal: '',
  empAddress: '',
  deptId: '',
};



const initialStateDept = {
    // Define your initial state for department here
    deptName: ''
  };


const appReducer = (state, action) => {
  switch (action.type) {
    case 'SET_empName':
      return { ...state, empName: action.payload };
    case 'SET_empEmail':
      return { ...state, empEmail: action.payload };
    case 'SET_empSal':
      return { ...state, empSal: action.payload };
    case 'SET_empAddress':
      return { ...state, empAddress: action.payload };
    case 'SET_deptId':
      return { ...state, deptId: action.payload };
    case 'SET_deptName':
        return { ...state, deptName: action.payload };
    default:
      return state;
  }
};



const appReducerDept = (state, action) => {
    switch (action.type) {
      case 'SET_deptName':
        return { ...state, deptName: action.payload };
   
      default:
        return state;
    }
  }


const AppProvider = ({ children }) => {
  const [state, dispatch] = useReducer(appReducer, initialState);

  const [stateDept, dispatchDept] = useReducer(appReducerDept, initialStateDept); // Add a new state and dispatcher for department data


  return (
    <AppContext.Provider value={{ state, dispatch }}>
      <AppContextDept.Provider value={{ stateDept, dispatchDept }}>
        {children}
      </AppContextDept.Provider>
    </AppContext.Provider>
  );
};

const useAppContext = () => {
  const context = useContext(AppContext);
  if (context === undefined) {
    throw new Error('useAppContext must be used within an AppProvider');
  }
  return context;
};



const useAppContextDept = () => {
    const context = useContext(AppContextDept); // Create a custom hook for the department context
    if (context === undefined) {
      throw new Error('useAppContextDept must be used within an AppProvider');
    }
    return context;
  };

export { AppProvider, useAppContext,AppContextDept,useAppContextDept };
