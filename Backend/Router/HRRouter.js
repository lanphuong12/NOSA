var express = require('express');
//Use router funtion from express
var router = express.Router();
    //requie teacher controller
const hrController = require("../src/HRController")
    //handles post request with url /api/login
router.post('/GetApplicant', hrController.GetApplicantforHr);
router.post('/GetJobCreated', hrController.GetJobCreated);
router.post('/GetCompanyCreated', hrController.GetCompanyCreated);
router.post('/GetAllCVApplied', hrController.GetAllCVApplied);
router.post('/GetAllCVAppliedByIdJob', hrController.GetAllCVAppliedByIdJob);
router.post('/UpdateStatusCV', hrController.UpdateStatusCV);
router.post('/GetCVbyStatus', hrController.GetCVbyStatus);
router.post('/GetJobByIdCompany', hrController.GetJobByIdCty);
// export router to use in index file
module.exports = router;