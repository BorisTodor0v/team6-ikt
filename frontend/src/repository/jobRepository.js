import axios from "../custom-axios/axios";

const JobService = {
    fetchAllJobs: () => {
        return axios.get("/jobs");
    },
    fetchJobById: (id) => {
        return axios.get(`/jobs/${id}`);
    },
    postJob: (title, description, salary, location, experienceRequired, categories, postedBy) => {
        return axios.post('/jobs/create', {
            "title": title,
            "description": description,
            "salary": salary,
            "location": location,
            "experienceRequired": experienceRequired,
            "categories": categories,
            "postedBy": postedBy
        })
    },
    editJob: (id, title, description, salary, location, experienceRequired, categories) => {
        return axios.put(`/jobs/${id}/edit`, {
            "title": title,
            "description": description,
            "salary": salary,
            "location": location,
            "experienceRequired": experienceRequired,
            "categories": categories
        })
    },
    deleteJob: (id) => {
        return axios.delete(`/jobs/${id}/delete`)
    }
}

export default JobService;