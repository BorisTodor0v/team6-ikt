import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import LoginAndRegister from '../Login & Register/LoginAndRegister';
import Header from "../Header/Header";
import UserService from "../../repository/userRepository";
import ListUsers from "../ListAllUsers/List Users";
import Introduction from "../Introduction/Introduction";
import AboutUs from "../AboutUs/AboutUs";
import Contact from "../Contact/Contact";
import Services from "../Services/Services";
import Footer from "../Footer/Footer";

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
                            <Route path={"/"} element={<Introduction/>}/>
                            <Route path={"/users"} element={<ListUsers users={this.state.users}/>}/>
                            <Route path={"/auth"} element={<LoginAndRegister/>}/>
                            <Route path={"/about-us"} element={<AboutUs/>}/>
                            <Route path={"/contact"} element={<Contact/>}/>
                            <Route path={"/services"} element={<Services/>}/>
                        </Routes>
                    </div>
                </main>
                <Footer/>
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
