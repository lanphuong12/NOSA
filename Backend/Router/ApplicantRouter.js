var express = require('express');
//Use router funtion from express
var router = express.Router();
    //requie teacher controller
const applicantController = require("../src/ApplicantController")
    //handles post request with url /api/login
router.get('/getalldanhmucnganhnghe', applicantController.GetAllDanhmucnganhnghe);
router.get('/getallnganhnghebtIdDMNN', applicantController.GetAllnganhngheByIdDMNN);
router.post('/AddNganhnghequantam', applicantController.AddNganhnghequantam);
router.post('/AddExperience', applicantController.AddExperience);
router.post('/UpdateExperience', applicantController.UpdateExperience);
router.put('/DeleteExperience', applicantController.DeleteExperience);
router.post('/AddSkill', applicantController.AddSkill);
router.post('/UpdateSkill', applicantController.UpdateSkill);
router.put('/DeleteSkill', applicantController.DeleteSkill);
router.get('/GetJobtoApplicant', applicantController.GetJobtoApplicant);
router.get('/GetSavedJob', applicantController.GetSavedJob);
router.get('/GetAppliedJob', applicantController.GetAppliedJob);
router.get('/GetAppliedJobByStatusReject', applicantController.GetAppliedJobByStatusReject);
router.get('/GetAppliedJobByStatusWaiting', applicantController.GetAppliedJobByStatusWaiting);
router.get('/GetAppliedJobByStatusApproved', applicantController.GetAppliedJobByStatusApproved);
router.get('/GetAppliedJobByStatusConsider', applicantController.GetAppliedJobByStatusConsider);
// export router to use in index file
module.exports = router;