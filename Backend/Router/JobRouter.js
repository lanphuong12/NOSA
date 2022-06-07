var express = require('express');
//Use router funtion from express
var router = express.Router();
    //requie teacher controller
const jobController = require("../src/JobController")
    //handles post request with url /api/login
router.get('/GetJobByIdJob', jobController.GetJobByIdJob);
router.post('/UpdateJob', jobController.UpdateJob);
router.get('/GetJobByIdSkillJob', jobController.GetJobByIdSkillJob);
router.post('/AddJob', jobController.AddJob);
router.get('/GetJobBySalary', jobController.GetJobBySalary);
router.get('/GetJobByName', jobController.GetJobByName);
// export router to use in index file
module.exports = router;