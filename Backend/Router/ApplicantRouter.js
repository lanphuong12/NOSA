var express = require('express');
//Use router funtion from express
var router = express.Router();
    //requie teacher controller
const applicantController = require("../src/ApplicantController")
    //handles post request with url /api/login
router.get('/getalldanhmucnganhnghe', applicantController.GetAllDanhmucnganhnghe);
router.get('/getallnganhnghebtIdDMNN', applicantController.GetAllnganhngheByIdDMNN);

// export router to use in index file
module.exports = router;