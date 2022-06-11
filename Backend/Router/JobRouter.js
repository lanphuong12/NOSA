var express = require('express');
//Use router funtion from express
var router = express.Router();
    //requie teacher controller
const jobController = require("../src/JobController")
    //handles post request with url /api/login
router.post('/GetJobByIdJob', jobController.GetJobByIdJob);
router.post('/UpdateJob', jobController.UpdateJob);
router.post('/GetJobByIdSkillJob', jobController.GetJobByIdSkillJob);
router.post('/AddJob', jobController.AddJob);
router.post('/GetJobBySalary', jobController.GetJobBySalary);
router.post('/GetJobByName', jobController.GetJobByName);
// export router to use in index file
module.exports = router;