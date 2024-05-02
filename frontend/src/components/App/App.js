import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import LoginAndRegister from '../Login & Register/LoginAndRegister';
import Header from "../Header/Header";
import UserService from "../../repository/userRepository";
import ListUsers from "../ListAllUsers/List Users";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            users: []
        }
    }

    render(){
        return(
            <Router>
                <Header/>
                <main>
                    <div>
                        <Routes>
                            <Route path={"/"} element={<ListUsers users={this.state.users}/>}/>
                            <Route path={"/users"} element={<ListUsers users={this.state.users}/>}/>
                            <Route path={"/auth"} element={<LoginAndRegister/>}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        )
    }

    getAllUsers = () => {
        UserService.fetchAllUsers().then((data)=>{
            this.setState({
                users: data.data
            })
        })
    }

    componentDidMount() {
        this.getAllUsers();
    }
}

export default App;
