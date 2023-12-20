INSERT INTO role (role_name) VALUES
    ('admin'),
    ('employee');

INSERT INTO user (username, role_id, salt, secured_password) VALUES
    ('Admin123', 1, 'qwertyui', '062742bd7303fd97dc3e059dc3595e97114ae28815901c518b9a4e283e9512f6'),
    ('Employee123', 2, 'asdfghjk', '79fb350ff31e939d2b5d4b8ed498e2ec6782eed7943e943d29e40c6e4fbd077d');
    
-- Insert statements for the job roles table
INSERT INTO job_role (job_role_name) VALUES
    ('Innovation Lead'),
    ('Technology Leader'),
    ('Software Engineer'),
    ('Software Engineer'),
    ('Support Technician'),
    ('Front-End Engineer'),
    ('Software Engineer'),
    ('Senior Support Technician'),
    ('Senior Front-End Engineer'),
    ('Senior Software Engineer'),
    ('Lead Managed Services Engineer'),
    ('Lead Software Engineer'),
    ('Technical Architect'),
    ('Solution Architect'),
    ('Dynamics 365 / Power Platform Solution Architect'),
    ('Principal Architect'),
    ('Test Engineer'),
    ('Test Engineer'),
    ('Senior NFT Engineer'),
    ('Senior Test Engineer'),
    ('Test Manager'),
    ('Lead NFT Engineer'),
    ('Lead Test Engineer'),
    ('Test Architect'),
    ('Principal Test Architect'),
    ('Product Specialist'),
    ('Senior Product Specialist'),
    ('Lead Product Specialist'),
    ('Intelligent Automation Solution Architect'),
    ('Low Code Engineer'),
    ('Low Code Engineer'),
    ('Low Code Principal Architect'),
    ('Head of Cloud Practice'),
    ('Lead Platform Engineer'),
    ('Senior Platform Engineer'),
    ('Platform Engineer'),
    ('Trainee Platform Engineer'),
    ('Principal Architect'),
    ('Solution Architect'),
    ('Technical Architect'),
    ('Senior Technical Specialist'),
    ('Cloud Economist'),
    ('Technical Specialist'),
    ('Cloud Migration Architect'),
    ('Cloud Migration Lead'),
    ('Head of IT Operations'),
    ('Systems Operations Manager'),
    ('Service Category Lead'),
    ('Lead Systems Support Engineer'),
    ('Service Category Lead'),
    ('Senior Systems Support Engineer'),
    ('Systems Support Engineer'),
    ('Trainee Systems Support Engineer'),
    ('Senior Systems Support Engineer'),
    ('Systems Support Engineer'),
    ('Trainee Systems Support Engineer'),
    ('Data Solution Architect'),
    ('Lead Data Technical Architect'),
    ('Lead Data Engineer'),
    ('Senior Data Engineer'),
    ('Data Engineer'),
    ('Trainee Data Engineer'),
    ('Principal Architect (Data and AI)'),
    ('Data Architect'),
    ('Data Architect'),
    ('AI Engineering Manager'),
    ('Lead AI Engineer'),
    ('Senior AI Engineer'),
    ('Associate AI Engineer'),
    ('Trainee AI Engineer'),
    ('Data Science Manager'),
    ('Consultant Data Scientist'),
    ('Senior Data Scientist'),
    ('Associate Data Scientist'),
    ('Trainee Data Scientist'),
    ('Principal Data and AI Consultant'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Data Migration Architect'),
    ('Data Analytics Manager'),
    ('Lead Data Analyst'),
    ('Senior Data Analyst'),
    ('Data Analyst'),
    ('Trainee Data Analyst'),
    ('Security Engineer'),
    ('Security Engineer'),
    ('Senior Security Engineer'),
    ('Security Architect, Lead Security Engineer'),
    ('Senior Security Architect'),
    ('Principal Security Architect'),
    ('Cyber Risk Assessor'),
    ('Security Analyst'),
    ('Senior Security Analyst'),
    ('Lead Security Analyst'),
    ('Corporate Security Manager'),
    ('Workday Practice Strategy and Planning Delivery Director'),
    ('HCM Solution Architect'),
    ('HCM Consultant'),
    ('HCM Consultant'),
    ('HCM Consultant'),
    ('HCM Consultant'),
    ('HCM Consultant'),
    ('Financials Solution Architect'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Data Solution Architect'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Integrations Solution Architect'),
    ('Integrations Consultant'),
    ('Integrations Consultant'),
    ('Integrations Consultant'),
    ('Integrations Consultant'),
    ('Integrations Consultant'),
    ('Head of Change and User Adoption'),
    ('Change and User Adoption Solution Architect'),
    ('Change and User Adoption Consultant'),
    ('Change and User Adoption Consultant'),
    ('Change and User Adoption Consultant'),
    ('Change and User Adoption Consultant'),
    ('Change and User Adoption Consultant'),
    ('Adaptive Planning Solution Architect'),
    ('Adaptive Planning Solution Architect'),
    ('Adaptive Planning Consultant'),
    ('Adaptive Planning Consultant'),
    ('Adaptive Planning Consultant'),
    ('Head of Customer Engagement - Products'),
    ('Delivery Director'),
    ('Principal Test Manager'),
    ('Technical Lead'),
    ('Test Manager'),
    ('Test Consultant'),
    ('Test Consultant'),
    ('Test Consultant'),
    ('Test Consultant'),
    ('Principal Product Manager'),
    ('Product Manager'),
    ('Product Owner'),
    ('Product Marketing Consultant'),
    ('Product Owner'),
    ('Business Analyst'),
    ('Workday Extend Principal Architect'),
    ('Workday Extend Architect'),
    ('Workday Extend Architect'),
    ('Workday Extend Developer'),
    ('Workday Extend Developer'),
    ('Workday Extend Trainee'),
    ('Service Delivery Principal'),
    ('Advisory Principal'),
    ('Service Delivery Manager'),
    ('Advisory Manager'),
    ('Service Delivery Consultant'),
    ('Service Delivery Senior Associate'),
    ('Service Delivery Associate'),
    ('Service Delivery Associate'),
    ('User Researcher'),
    ('User Researcher'),
    ('User Researcher'),
    ('User Researcher'),
    ('User Researcher Lead'),
    ('Experience Design Principal'),
    ('Chief Design Officer'),
    ('Content Designer'),
    ('Content Designer'),
    ('Content Designer Lead'),
    ('Experience Design Principal'),
    ('Chief Design Officer'),
    ('UX Designer'),
    ('UX Designer'),
    ('UX Designer'),
    ('UX Designer'),
    ('UX Design Lead'),
    ('Experience Design Principal'),
    ('Chief Design Officer'),
    ('Service Designer'),
    ('Experience Strategy Lead'),
    ('Service Design Lead'),
    ('Experience Design Principal'),
    ('Chief Design Officer'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Digital Advisory Consultant'),
    ('Digital Advisory Consultant'),
    ('Digital Advisory Consultant'),
    ('Digital Advisory Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Delivery Lead'),
    ('Principal Delivery Manager'),
    ('Programme Manager'),
    ('Delivery Manager'),
    ('Engagement Manager'),
    ('Senior Agility Coach'),
    ('Team Lead'),
    ('Engagement Manager'),
    ('Agile Coach'),
    ('Delivery Manager'),
    ('Agile Practitioner'),
    ('Principal Engineering Manager'),
    ('Principal Service Manager'),
    ('Senior Service Manager'),
    ('Service Manager'),
    ('Service Lead'),
    ('Engagement Manager'),
    ('Engagement Manager'),
    ('Engagement Manager'),
    ('Engagement Manager'),
    ('Engagement Manager'),
    ('Programme Office Lead'),
    ('Programme Office Assistant'),
    ('Programme Office Assistant'),
    ('Programme Office Assistant'),
    ('Director of Operations'),
    ('Financial Operations Analyst'),
    ('Operations Manager'),
    ('Operations Manager'),
    ('Head of Operations'),
    ('Staffing Consultant'),
    ('Staffing Consultant'),
    ('Staffing and PMO Lead'),
    ('Global Head of Marketing'),
    ('Business Development Lead'),
    ('Account Lead'),
    ('Business Development Associate'),
    ('Senior Business Development Associate'),
    ('Business Development Consultant'),
    ('Business Development Manager'),
    ('Business Development Director'),
    ('Customer Success Associate'),
    ('Customer Success Consultant'),
    ('Customer Success Manager'),
    ('Customer Success Manager'),
    ('Customer Success Director'),
    ('Cloud Partner Operations Manager'),
    ('Partners Consultant'),
    ('Partners Relationship Manager'),
    ('Partners Director'),
    ('Senior Bid Production Associate'),
    ('Technical Pre-Sales Consultant'),
    ('Big Production Consultant'),
    ('Big Production Manager'),
    ('Big Production Director/Head of Product Presales'),
    ('Sales Development Representative'),
    ('Senior Sales Development Representative'),
    ('Sales Development Consultant'),
    ('Sales Development Manager'),
    ('Product Demand Generation Director'),
    ('Marketing Assistant'),
    ('Marketing Associate'),
    ('Marketing Executive'),
    ('Senior Marketing Executive'),
    ('Marketing Manager'),
    ('Marketing Director'),
    ('Martech and Ops Assistant'),
    ('Martech and Ops Associate'),
    ('Martech and Ops Executive'),
    ('Senior Martech and Ops Executive'),
    ('Marketing Operations Manager'),
    ('Digital Strategy Manager'),
    ('Digital Strategy Director'),
    ('Head of Practice'),
    ('Head of Quality and Compliance'),
    ('Chief Information Officer (CIO)'),
    ('Regional/Sector Lead'),
    ('Head of Planning and Strategic Initiatives'),
    ('Practice Lead'),
    ('Chief AI Officer'),
    ('Chief Executive Officer (CEO)'),
    ('Chief Financial Officer (CFO)'),
    ('Chief People Officer (CPO)'),
    ('Investor Relations'),
    ('Director of Innovation'),
    ('Business Unit (BU) Head'),
    ('BU Chief Operating Officer (COO)'),
    ('Vice President of Business Development'),
    ('Workday Practice Director of Product'),
    ('Regional/Sector Director'),
    ('Chief Revenue Officer'),
    ('Head of Strategic Partnering'),
    ('People Principal'),
    ('People Operations Manager'),
    ('People Operations Consultant'),
    ('Senior People Operations Associate'),
    ('People Operations Associate'),
    ('People Operations Trainee'),
    ('Head of Organisational Development & Learning'),
    ('Talent Development & Learning Principal'),
    ('Organisational Development & Learning Manager'),
    ('Internal Communications Manager'),
    ('Organisational Development & Learning Consultant'),
    ('Entry Level Partner'),
    ('Senior Organisational Development & Learning Associate'),
    ('Organisational Development & Learning Associate'),
    ('Global Head of Talent Acquisition'),
    ('Head of Talent Acquisition'),
    ('Talent Acquisition Manager'),
    ('Talent Acquisition Lead'),
    ('Talent Acquisition Partner'),
    ('Talent Acquisition Specialist'),
    ('Global Head of Commercial'),
    ('Group Head of Finance'),
    ('Senior Commercial Associate'),
    ('Commercial Consultant'),
    ('Commercial Manager'),
    ('Senior Commercial Manager'),
    ('Finance Trainee'),
    ('Finance Associate'),
    ('Senior Finance Associate'),
    ('Finance Consultant'),
    ('Finance Manager'),
    ('Group Financial Controller'),
    ('Payroll Trainee'),
    ('Payroll Associate'),
    ('Payroll Senior Associate'),
    ('Payroll Consultant'),
    ('Payroll Manager'),
    ('Head of Business Services Support'),
    ('Business Services Support Manager'),
    ('Business Services Support Consultant'),
    ('Senior Business Services Support Associate'),
    ('Business Services Support Associate'),
    ('Business Services Support Trainee'),
    ('Head of Property'),
    ('Property Manager'),
    ('Property Team Lead'),
    ('Head of Travel'),
    ('Travel Manager'),
    ('Travel Team Lead'),
    ('Head of Social Responsibility'),
    ('Social Responsibility Manager'),
    ('Education and Partnerships Lead'),
    ('Environmental Sustainability Lead'),
    ('Outreach and Engagement Senior Associate');


UPDATE job_role
SET specification_summary = 'As an Innovation Lead (Consultant) in Kainos, you’ll be responsible for leading efforts in providing advice and identifying new ways to use technology to solve customer problems. This is a dynamic and hands-on role which will involve leading the team, implementing and shaping Kainos’ innovation strategy and effectively communicating the exciting work we undertake both internally and within the wider technology community.', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Technology%20Leader%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 1;

UPDATE job_role
SET specification_summary = 'A technology leader is key strategic role within the business making executive technology decisions on behalf of the business, based upon the sector and practices’ strategic direction and goals.The core responsibilities of a technology leader in Kainos include setting a Technology direction, a technical advisor to the business and C-level clients, maintaining a commercial edge over other technology services providers, developing and nurturing technical talent across the organisation and representing Kainos as a technology evangelist.', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Technology%20Leader%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 2;

UPDATE job_role
SET specification_summary = 'The Kainos Earn as you Learn Programme is back! Our highly-regarded scheme gives the opportunity to work for us as an Apprentice Software Engineer four days per week, while studying for a part time degree in Computing Systems one day per week, with Ulster University, Jordanstown, completing your degree in just four and a half years. The best of both worlds! This is an excellent opportunity to combine real work and technical experience within our fast-changing company, with the formal studies that you need to progress your career in IT. It’s a no brainer! We’ll pay all of your University fees, provide you with a brandnew laptop as well as a full-time salary throughout.  Oh, and it doesn’t end there. You will be offered a permanent position with us from day one, and we’ll help you to quickly progress up our ranks with our excellent (and award-winning!) in-house training programme Kainos MAP. It’s a great way to compliment your studies.',
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Apprentice%20Software%20Engineer%20%28Apprentice%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 3;

UPDATE job_role
SET specification_summary = 'As a Trainee Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – the lives of people you know. After taking part in our award-winning, seven-week Engineering Academy, you will then join one of our many project teams, to learn from our experienced developers, project managers and customer-facing staff. You’ll have great support and mentoring, balanced with the experience of being given real, meaningful work to do, to help you truly develop both technically and professionally. ', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Software%20Engineer%20%28Trainee%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 4;

UPDATE job_role
SET specification_summary = 'As a Support Technician (Associate) in Kainos, you’ll be responsible for analysing and solving complicated technical issues. You will adhere to ITIL standards and will participate fully in the Incident management lifecycle. You will work closely with clients, internal teams and 3rd Party vendors to ensure that problems are resolved. You’ll do this whilst learning about new approaches, with talented colleagues that will help you to learn, develop and grow. ', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Support%20Technician%20%28As%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 5;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/sites/PeopleTeam-SharedDrive/Shared%20Documents/Forms/AllItems.aspx?id=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering%2FJob%20Profile%20%2D%20Front%2DEnd%20Engineer%20%28A%29%2Epdf&parent=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering'
WHERE job_role_id = 6;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Software%20Engineer%20%28Associate%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 7;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Senior%20Support%20Technician%20%28SA%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 8;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/sites/PeopleTeam-SharedDrive/Shared%20Documents/Forms/AllItems.aspx?id=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering%2FJob%20Profile%20%2D%20Senior%20Front%2DEnd%20Engineer%20%28SA%29%2Epdf&parent=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering'
WHERE job_role_id = 9;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Senior%20Software%20Engieneer%20%28Senior%20Associate%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 10;

-- Insert statements for job_family_group table
INSERT INTO job_family_group (job_family_group_name) VALUES 
	('Engineering'),
	('Platforms'),
	('Data and AI'),
	('Cyber Security'),
	('Workday'),
	('Experience Design'),
	('Product'),
	('Delivery'),
	('Operations'),
	('Business Development and Market'),
	('OS and Planning'),
	('People'),
	('Commercial and Financial Management'),
	('Business Services Support');
    
-- Insert statements for job_family table
INSERT INTO job_family (job_family_name, job_family_group_id) VALUES
    ('Engineering Strategy and Planning', 1),
    ('Engineering', 1),
    ('Architecture', 1),
    ('Testing and Quality Assurance', 1),
    ('Product Specialist', 1),
    ('Low Code Engineering', 1),
    ('Platform Strategy and Planning', 2),
    ('Platform Engineering', 2),
    ('Platform Architecture', 2),
    ('Platform Specialists', 2),
    ('Cloud Migration', 2),
    ('Systems Support', 2),
    ('Data Engineering', 3),
    ('Data Architecture', 3),
    ('Artificial Intelligence (AI) Engineering', 3),
    ('Data Science', 3),
    ('Data Consulting', 3),
    ('Data Analytics', 3),
    ('Security Strategy and Planning', 4),
    ('Security Engineering', 4),
    ('Corporate Security', 4),
    ('Strategy and Planning', 5),
    ('HCM', 5),
    ('Financials', 5),
    ('Data', 5),
    ('Integrations', 5),
    ('Change & User Adoption', 5),
    ('Adaptive Planning', 5),
    ('Product Services', 5),
    ('Product Development', 5),
    ('Extend', 5),
    ('Spend Management', 5),
    ('Insights', 6),
    ('Content Design', 6),
    ('UX / Visual Design', 6),
    ('Service Design', 6),
    ('Product Consultancy', 7),
    ('Digital Advisory Consultancy', 7),
    ('Low Code Consultancy', 7),
    ('Delivery Strategy & Planning', 8),
    ('Delivery Management', 8),
    ('Engineering Management', 8),
    ('Service Management', 8),
    ('Workday Engagement Management', 8),
    ('Programme Management Office (PMO)', 8),
    ('Operations Strategy and Planning', 9),
    ('Operational Management', 9),
    ('Staff Management', 9),
    ('Strategy and Planning', 10),
    ('Business Development', 10),
    ('Client Management', 10),
    ('Partners', 10),
    ('Bid Production', 10),
    ('Inside Sales', 10),
    ('Marketing – Business', 10),
    ('Marketing – Martech', 10),
    ('Organisational', 11),
    ('People Strategy and Planning', 12),
    ('People Operations / Strategic Partnering', 12),
    ('Engagement, Culture and Development', 12),
    ('Talent Acquisition', 12),
    ('Commercial and Financial Management Strategy & Planning', 13),
    ('Commercial', 13),
    ('Financial Management', 13),
    ('Payroll', 13),
    ('Business Services', 14),
    ('Property Management', 14),
    ('Travel Management', 14),
    ('Corporate Social Responsibility Management', 14);

UPDATE job_role
SET job_family_id = 1
WHERE job_role_id BETWEEN 1 AND 2;

UPDATE job_role
SET job_family_id = 2
WHERE job_role_id BETWEEN 3 AND 12;

UPDATE job_role
SET job_family_id = 3
WHERE job_role_id BETWEEN 13 AND 16;

UPDATE job_role
SET job_family_id = 4
WHERE job_role_id BETWEEN 17 AND 25;

UPDATE job_role
SET job_family_id = 5
WHERE job_role_id BETWEEN 26 AND 29;

UPDATE job_role
SET job_family_id = 6
WHERE job_role_id BETWEEN 20 AND 32;

SELECT * FROM job_role;

UPDATE job_role
SET job_family_id = 7
WHERE job_role_id = 33;

UPDATE job_role
SET job_family_id = 8
WHERE job_role_id BETWEEN 34 AND 37;

UPDATE job_role
SET job_family_id = 9
WHERE job_role_id BETWEEN 38 AND 40;

UPDATE job_role
SET job_family_id = 10
WHERE job_role_id BETWEEN 41 AND 43;

UPDATE job_role
SET job_family_id = 11
WHERE job_role_id BETWEEN 44 AND 45;

UPDATE job_role
SET job_family_id = 12
WHERE job_role_id BETWEEN 46 AND 56;

UPDATE job_role
SET job_family_id = 13
WHERE job_role_id BETWEEN 57 AND 62;

UPDATE job_role
SET job_family_id = 14
WHERE job_role_id BETWEEN 63 AND 65;

UPDATE job_role
SET job_family_id = 15
WHERE job_role_id BETWEEN 66 AND 70;

UPDATE job_role
SET job_family_id = 16
WHERE job_role_id BETWEEN 71 AND 75;

UPDATE job_role
SET job_family_id = 17
WHERE job_role_id BETWEEN 76 AND 79;

UPDATE job_role
SET job_family_id = 18
WHERE job_role_id BETWEEN 80 AND 84;