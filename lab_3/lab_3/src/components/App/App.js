import React,{Component} from 'react';
import './App.css';
import {withRouter,Redirect,Switch,Route} from 'react-router-dom'
import Header from "../Header/header";
import Ingredients from "../Ingredients/ingredients";
import IngredientAdd from "../Ingredients/ingredientAdd";
import IngredientEdit from "../Ingredients/ingredientEdit";
import IngredientService from "../../repository/axiosIngredientsRepository";
import IngredientDetails from "../Ingredients/ingredientDetails";
import Pizza from "../Pizza/pizza"

class App extends Component{

    constructor(props) {
        super(props);
        this.state = {
            ingredients: []
        }
    }

    componentDidMount() {
        this.loadIngredients();
    }

    loadIngredients = () => {
        IngredientService.fetchIngredients().then(result => {
            this.setState(() => {
                return {
                    "ingredients": result.data.content
                }
            })
        });
    };


    createIngredient = (ingredient) => {
        IngredientService.addIngredient(ingredient).then((response)=>{
            const newIngredient = response.data;
            this.setState((prevState) => {
                const newIngredientsRef = [...prevState.ingredients, newIngredient];

                return {
                    "ingredients": newIngredientsRef
                }
            });
            this.props.history.push("/ingredients");
        });
    };

    editIngredient = (editedIngredient) => {
        IngredientService.updateIngredient(editedIngredient).then((response)=>{
            const newIngredient = response.data;
            this.setState((prevState) => {
                const newIngredientsRef = prevState.ingredients.map((item)=>{

                    if (item.name===newIngredient.name) {
                        return newIngredient;
                    }
                    return item;
                });
                return {
                    "ingredients": newIngredientsRef
                }
            });
        });
    };
    deleteIngredients = (ingredientId) => {
        IngredientService.deleteIngredient(ingredientId).then(()=>{
            this.setState((state) => {
                const ingredients = state.ingredients.filter((t) => {
                    return t.name !== ingredientId;
                });
                return {ingredients}
            })
        })
    };



    render() {
        const routing = (
            <div>
                <Header/>
                <main role="main">
                    <div className="container">
                    <Switch>
                        <Route path={"/"} exact>
                            <h2>Home</h2>
                        </Route>
                        <Route path={"/pizza"} exact>
                            <Pizza/>
                        </Route>
                        <Route path={"/ingredients"} exact>
                            <Ingredients ingredients={this.state.ingredients} onDelete={this.deleteIngredients}/>
                        </Route>
                        <Route path={"/ingredients/new"} exact>
                            <IngredientAdd onNewIngredientAdded={this.createIngredient}/>
                        </Route>

                        <Route path={"/ingredients/:ingredientId/edit"} exact>
                            <IngredientEdit onEditIngredient={this.editIngredient}/>
                        </Route>

                        <Route path={"/ingredients/:ingredientId/details"} exact>
                            <IngredientDetails/>
                        </Route>

                        <Redirect to={"/"}/>
                    </Switch>
                    </div>
                </main>

            </div>

        );
        return (
            <div className="App">
                {routing}
            </div>
        );
    }
}

export default withRouter(App);
