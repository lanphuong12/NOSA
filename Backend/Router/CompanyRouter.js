var express = require('express');
//Use router funtion from express
var router = express.Router();
    //requie teacher controller
const companyController = require("../src/CompanyController")
    //handles post request with url /api/login
router.get('/GetCompanyByIdJob', companyController.GetCompanyByIdJob);
router.post('/UpdatedCompanyByIdCompany', companyController.UpdatedCompanyByIdCompany);
router.post('/AddCompany', companyController.AddCompany);
// export router to use in index file
module.exports = router;