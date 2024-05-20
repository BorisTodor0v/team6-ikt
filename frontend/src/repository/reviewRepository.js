import axios from "../custom-axios/axios";

const ReviewService = {
    fetchAllReviews: () => {
        return axios.get("/review");
    },
    fetchReviewById: (id) =>{
        return axios.get(`/review/${id}`)
    },
    createReview: (rating, comment, userFor, date, postedBy)=>{
        return axios.post("/review/create", {
            "rating": rating,
            "commentar": comment,
            "user": userFor,
            "date": date,
            "postUser": postedBy
        })
        //TODO: CHECK ReviewCreateDTO
    },
    editReview: (id, rating, comment) => {
        return axios.put(`/review/${id}/edit`, {
            "rating": rating,
            "commentar": comment
        })
        //TODO: CHECK ReviewEditDTO
    },
    deleteReview: (id) => {
        return axios.delete(`/review/${id}/delete`);
    },
    fetchReviewsForUser: (user) => {
        //TODO: ADD THIS FUNCTIONALITY IN CONTROLLER FIRST
    },
    fetchReviewsFromUser: (user) => {
        //TODO: ADD THIS FUNCTIONALITY IN CONTROLLER FIRST
    }
}

export default ReviewService;