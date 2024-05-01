import axios from "../custom-axios/axios";

const CategoryService = {
    fetchAllCategories: () => {
        return axios.get("/categories");
    },
    fetchCategoryById: (id) => {
        return axios.get(`/categories/${id}`);
    },
    createNewCategory: (name) => {
        return axios.post(`/api/categories/create`, {
            "name": name
        })
    }
}

export default CategoryService;
