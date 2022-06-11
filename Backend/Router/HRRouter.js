var express = require('express');
//Use router funtion from express
var router = express.Router();
    //requie teacher controller
const hrController = require("../src/HRController")
    //handles post request with url /api/login
router.get('/GetApplicant', hrController.GetApplicant);
router.get('/GetJobCreated', hrController.GetJobCreated);
router.get('/GetCompanyCreated', hrController.GetCompanyCreated);
router.get('/GetAllCVApplied', hrController.GetAllCVApplied);
router.get('/GetAllCVAppliedByIdJob', hrController.GetAllCVAppliedByIdJob);
router.post('/UpdateStatusCV', hrController.UpdateStatusCV);
router.get('/GetCVbyStatus', hrController.GetCVbyStatus);
// export router to use in index file
module.exports = router;