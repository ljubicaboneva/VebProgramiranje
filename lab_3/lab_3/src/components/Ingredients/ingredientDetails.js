import React,{useState,useEffect} from 'react';
import {useParams} from "react-router";
import IngredientService from "../../repository/axiosIngredientsRepository";
import {useHistory} from "react-router-dom";


const IngredientDetails = (props) => {

    const [ingredient,setIngredient] = useState({});
    const {ingredientId} = useParams();
    const [pizzas, setPizzas] = useState([]);

    useEffect(() => {
        IngredientService.pizzasIngredient(ingredientId).then(data => {
            setPizzas(data.data.map(pizza => pizza.name));
            })
    },[]);

    const pizzasL = pizzas.map((pizza, index) =>
        <p>{pizza}</p>

     );

    const pizzasIn = () => {
        if (pizzas.length) {
            return (
                <p>{pizzasL}</p>
            )
        } else {
            return (
                <div>No pizzas.</div>
            )
        }
    };


    useEffect(() => {
        IngredientService.fetchIngredient(ingredientId).then(data => {
            setIngredient(data.data);
        })
    },[]);

        return (
            <div>
                <div>
                    <h3>{ingredient.name}</h3>
                    <p><span className="font-weight-bold">Amount:</span> {ingredient.amount}g</p>
                    <p><span className="font-weight-bold">Veggie:</span>  <i className={ingredient.veggie ? "fa fa-check-circle text-success" : "fa fa-minus-circle text-danger"}/></p>
                    <p><span className="font-weight-bold">Spicy:</span>  <i className={ingredient.spicy ? "fa fa-check-circle text-success" : "fa fa-minus-circle text-danger"}/></p>
                    <p><span className="font-weight-bold">Pizzas:</span>
                        {pizzasIn()}</p>
                </div>

            </div>
        );


};

export default IngredientDetails;