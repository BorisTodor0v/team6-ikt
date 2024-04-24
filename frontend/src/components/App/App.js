import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import LoginAndRegister from '../Login & Register/LoginAndRegister';
import Header from "../Header/Header";

class App extends Component {

    constructor(props) {
        super(props);
    }

    render(){
        return(
            <Router>
                <Header/>
                <main>
                    <div>
                        <Routes>
                            <Route path={"/"} element={<LoginAndRegister/>}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        )
    }
}

export default App;
