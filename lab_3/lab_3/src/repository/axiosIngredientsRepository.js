import axios from '../axios/axios';
import qs from 'qs';

const IngredientsService = {

    fetchIngredients(){
        return axios.get("http://localhost:8080/ingredients/");
    },
    fetchIngredient(id){
        return axios.get(`http://localhost:8080/ingredients/${id}`);
    },

    addIngredient: (ingredient) => {
        const formParams = qs.stringify(ingredient);
        return axios.post("http://localhost:8080/ingredients/",formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }
        });
    },

    updateIngredient : (ingredient) => {
        const data = {
            ...ingredient,
            name:ingredient.name

        };
        const ingredientId= ingredient.name;
        const formParams = qs.stringify(data);
        return axios.patch(`http://localhost:8080/ingredients/${ingredientId}`,formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',

            }
        });
    },
    deleteIngredient:(ingredientId) => {
        return axios.delete(`http://localhost:8080/ingredients/${ingredientId}`);
    },
    pizzasIngredient:(ingredientId) => {
        return axios.get(`http://localhost:8080/ingredients/${ingredientId}/pizzas`);
    }





};
export default IngredientsService;