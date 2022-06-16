var express = require('express');
//Use router funtion from express
var router = express.Router();
    //requie teacher controller
const applicantController = require("../src/ApplicantController")
    //handles post request with url /api/login 

router.post('/GetUserById', applicantController.GetUserById);
router.get('/GetAllDanhmucnganhnghe', applicantController.GetAllDanhmucnganhnghe);
router.post('/GetAllnganhngheByIdDMNN', applicantController.GetAllnganhngheByIdDMNN);
router.post('/AddNganhnghequantam', applicantController.AddNganhnghequantam);
router.post('/GetExpByIdUser', applicantController.GetExpByIdUser);
router.post('/AddExperience', applicantController.AddExperience);
router.post('/UpdateExperience', applicantController.UpdateExperience);
router.put('/DeleteExperience', applicantController.DeleteExperience);
router.post('/GetSkillByIdUser', applicantController.GetSkillByIdUser);
router.post('/AddSkill', applicantController.AddSkill);
router.post('/UpdateSkill', applicantController.UpdateSkill);
router.put('/DeleteSkill', applicantController.DeleteSkill);
router.post('/GetDanhmucnganhNgheByIdUser', applicantController.GetDanhmucnganhNgheByIdUser);
router.post('/GetNganhNgheByIdUserIddmnn', applicantController.GetNganhNgheByIdUserIddmnn);
router.post('/GetJobtoApplicant', applicantController.GetJobtoApplicant);
router.post('/GetSavedJob', applicantController.GetSavedJob);
router.post('/GetAppliedJob', applicantController.GetAppliedJob);
router.post('/GetAppliedJobByStatus', applicantController.GetAppliedJobByStatus);
router.get('/GetDataTrinhdohocvan', applicantController.GetDataTrinhdohocvan);
router.get('/GetDataLoaiSkill', applicantController.GetDataLoaiSkill);
router.post('/GetDataSkillByIdLoaiSkill', applicantController.GetDataSkillByIdLoaiSkill);
router.post('/ApplyJob', applicantController.ApplyJob);
router.post('/SaveJob', applicantController.SaveJob);
// export router to use in index file
module.exports = router;