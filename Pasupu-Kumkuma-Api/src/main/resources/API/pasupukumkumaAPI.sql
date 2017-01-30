MASTER ROLES:
=============

1. Create ROLE
=====================================
url : /master/role
ex url : /master/role
method : POST
data : 

{
  "name" : "admin", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role Created sucessfully/ Failed to create role"
	"data" : null
} 

2 Edit  role
=====================================
url : /master/role/<ROLE_ID>
ex url : /master/role/2

method : PUT
data : 

{
  "name" : "admin", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role updated sucessfully/ Failed to update role"
	"data" : null
} 

3. Get All role
=====================================
url : /master/role
ex url : /master/role

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role updated sucessfully/ Failed to update role"
	"data" : [
		{"id" : 1, "name" : "admin", "description" : " master data description……"}, {},...
	]
} 

4. Get role
=====================================
url : /master/role/<ROLE_ID>
ex url : /master/role/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role updated sucessfully/ Failed to update role"
	"data" : {"id" : 2, "name" : "admin", "description" : " master data description…"}
	
} 

5. Delete role
=====================================
url : /master/role/<ROLE_ID>
ex url : /master/role/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role deleted sucessfully/ failed to update role"
	"data" : NULL
	
} 
========================================================================================
MASTER GENDER:
==============

1. Create GENDER
=====================================
url : /master/gender
ex url : /master/gender
method : POST
data : 

{
  "name" : "male", 
  "code" : "M",
  "description" : " master description…", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender Created sucessfully/ failed to create gender"
	"data" : null
} 

2 Edit  gender
=====================================
url : /master/gender/<GENDER_ID>
ex url : /master/gender/2

method : PUT
data : 

{
  "name" : "male", 
  "code" : "M",
  "description" : "sdkjchsjk", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender updated sucessfully/ failed to update gender"
	"data" : null
} 

3. Get All gender
=====================================
url : /master/gender
ex url : /master/gender

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender updated sucessfully/ failed to update gender"
	"data" : [
		{"id" : 1, "name" : "male", "code" : "M",  "description" : "master description…"}, {},...
	]
} 

4. Get gender
=====================================
url : /master/gender/<GENDER_ID>
ex url : /master/gender/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender updated sucessfully/ failed to update gender"
	"data" : {"id" : 2, "name" : "male",  "code" : "M", "description" : " master description…"}
	
} 

5. Delete gender
=====================================
url : /master/gender/<GENDER_ID>
ex url : /master/gender/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender deleted sucessfully/ failed to update gender"
	"data" : NULL
	
} 
======================================================================================
MASTER COUNTRY
==============
1. Create COUNTRY
=====================================
url : /master/country
ex url : /master/country
method : POST
data : 

{
  "name" : "india", 
  "code" : "123"
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country Created sucessfully/ failed to create country"
	"data" : null
} 

2 Edit  country
=====================================
url : /master/country/<COUNTRY_ID>
ex url : /master/country/2

method : PUT
data : 

{
  "name" : "india", 
 "code" : "123"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country updated sucessfully/ failed to update country"
	"data" : null
} 

3. Get All country
=====================================
url : /master/country
ex url : /master/country

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country updated sucessfully/ failed to update country"
	"data" : [
		{"id" : 1, "name" : "india", "code" : "123"}, {},...
	]
} 

4. Get country
=====================================
url : /master/country/<COUNTRY_ID>
ex url : /master/country/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country updated sucessfully/ failed to update country"
	"data" : {"id" : 2, "name" : "india", "code" : "123"}
	
} 

5. Delete country
=====================================
url : /master/country/<COUNTRY_ID>
ex url : /master/country/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country deleted sucessfully/ failed to update country"
	"data" : NULL
	
} 
==============================================================================================
MASTER STATE:
=============
1. Create STATE
=====================================
url : /master/state
ex url : /master/state
method : POST
data : 

{
  "name" : "rajasthan", 
  "country_id" :"123" , 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state created sucessfully/ failed to create state"
	"data" : null
} 

2 Edit  state
=====================================
url : /master/state/<STATE_ID>
ex url : /master/state/2

method : PUT
data : 

{
  "name" : "rajasthan",  
  "country_id" :"123" , 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state updated sucessfully/ failed to update state"
	"data" : null
} 

3. Get All state
=====================================
url : /master/state
ex url : /master/state

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state updated sucessfully/ failed to update state"
	"data" : [
		{"id" : 1, "name" : "rajasthan", "country_id" :"123" , "code" : "123","orderNum" = "123"}, {},...
	]
} 

4. Get state
=====================================
url : /master/state/<STATE_ID>
ex url : /master/state/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state updated sucessfully/ failed to update state"
	"data" : {"id" : 2, "name" : "rajasthan", "country_id" :"123" ,  "description" : " master data description…"}
	
} 

5. Delete state
=====================================
url : /master/state/<STATE_ID>
ex url : /master/state/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state deleted sucessfully/ failed to update state"
	"data" : NULL
	
} 
===============================================================================================
MASTER CITY:
===========
1. Create CITY
=====================================
url : /master/city
ex url : /master/city
method : POST
data : 

{
  "name" : "jaipur", 
  "country_id" : "234", 
  "state_id" : "123" ,
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city created sucessfully/ failed to create city"
	"data" : null
} 

2 Edit  city
=====================================
url : /master/city/<CITY_ID>
ex url : /master/city/2

method : PUT
data : 

{
  "name" : "jaipur", 
  "country_id" : "234", 
  "state_id" : "123" , 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city updated sucessfully/ failed to update city"
	"data" : null
} 

3. Get All city
=====================================
url : /master/city
ex url : /master/city

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city updated sucessfully/ failed to update city"
	"data" : [
		{"id" : 1, "name" : "jaipur", "country_id" : "234", "state_id" : "123"}, {},...
	]
} 

4. Get city
=====================================
url : /master/city/<CITY_ID>
ex url : /master/city/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city updated sucessfully/ failed to update city"
	"data" : {"id" : 2, "name" : "jaipur","country_id" : "234", "state_id" : "123" }
	
} 

5. Delete city
=====================================
url : /master/city/<CITY_ID>
ex url : /master/city/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city deleted sucessfully/ failed to update city"
	"data" : NULL
	
} 

==================================================================================

MASTER RAASI:
=============

1. Create RAASI
=====================================
url : /master/rassi
ex url : /master/rassi
method : POST
data : 

{
  "name" : "tauras", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Rassi Created sucessfully/ Failed to create Raasi"
	"data" : null
} 

2 Edit  RAASI
=====================================
url : /master/rassi/<RAASI_ID>
ex url : /master/rassi/2

method : PUT
data : 

{
  "name" : "tauras", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "rassi updated sucessfully/ Failed to update rassi"
	"data" : null
} 

3. Get All RAASI
=====================================
url : /master/rassi
ex url : /master/rassi

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "rassi updated sucessfully/ Failed to update rassi"
	"data" : [
		{"id" : 1, "name" : "admin", "description" : " master data description……"}, {},...
	]
} 

4. Get RAASI
=====================================
url : /master/rassi/<RAASI_ID>
ex url : /master/rassi/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "rassi updated sucessfully/ Failed to update rassi"
	"data" : {"id" : 2, "name" : "admin", "description" : " master data description…"}
	
} 

5. Delete RAASI
=====================================
url : /master/rassi/<RAASI_ID>
ex url : /master/rassi/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "rassi deleted sucessfully/ failed to update rassi"
	"data" : NULL
	
} 
========================================================================================
MASTER NAKSHYATRAM:
=============

1. Create NAKSHYATRAM
=====================================
url : /master/nakshyatram
ex url : /master/nakshyatram
method : POST
data : 

{
  "name" : "ashwini", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "nakshyatram Created sucessfully/ Failed to create nakshyatram"
	"data" : null
} 

2 Edit  NAKSHYATRAM
=====================================
url : /master/nakshyatram/<NAKSHYATRAM_ID>
ex url : /master/nakshyatram/2

method : PUT
data : 

{
  "name" : "ashwini", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "nakshyatram updated sucessfully/ Failed to update nakshyatram"
	"data" : null
} 

3. Get All NAKSHYATRAM
=====================================
url : /master/nakshyatram
ex url : /master/nakshyatram

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "nakshyatram updated sucessfully/ Failed to update nakshyatram"
	"data" : [
		{"id" : 1, "name" : "ashwini", "description" : " master data description……"}, {},...
	]
} 

4. Get NAKSHYATRAM
=====================================
url : /master/nakshyatram/<NAKSHYATRAM_ID>
ex url : /master/nakshyatram/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "nakshyatram updated sucessfully/ Failed to update nakshyatram"
	"data" : {"id" : 2, "name" : "ashwini", "description" : " master data description…"}
	
} 

5. Delete NAKSHYATRAM
=====================================
url : /master/nakshyatram/<NAKSHYATRAM_ID>
ex url : /master/nakshyatram/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "nakshyatram deleted sucessfully/ failed to update nakshyatram"
	"data" : NULL
	
} 
========================================================================================
1. Create STATUS
=====================================
url : /master/status
ex url : /master/status
method : POST
data : 

{
  "name" : "error", 
  "description" : "master data description..", 
  "code" :"E",
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status created sucessfully/ failed to create status"
	"data" : null
} 

2 Edit  status
=====================================
url : /master/status/<STATUS_ID>
ex url : /master/status/2

method : PUT
data : 

{
  "name" : "error", 
  "description" : " master data description…..", 
  "code" :"E",
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status updated sucessfully/ failed to update status"
	"data" : null
} 

3. Get All status
=====================================
url : /master/status
ex url : /master/status

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status updated sucessfully/ failed to update status"
	"data" : [
		{"id" : 1, "name" : "error","code" :"E", "description" : " master data description……"}, {},...
	]
} 

4. Get status
=====================================
url : /master/status/<STATUS_ ID>
ex url : /master/status/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status updated sucessfully/ failed to update status"
	"data" : {"id" : 2, "name" : "error","code" :"E", "description" : " master data description…"}
	
} 

5. Delete status
=====================================
url : /master/status/<STATUS_ID>
ex url : /master/status/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status deleted sucessfully/ failed to update gender"
	"data" : NULL
	
} 
================================================================================
1. Create PUJA
=====================================
url : /master/puja
ex url : /master/puja
method : POST
data : 

{
  "name" : "ganesh puja", 
  "description" : "master data description..",
   "price" :"100",
   "duration" : "2 hours",
   "photo" : "c/fileserver/ganesh",
   
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja Created sucessfully/ Failed to create puja"
	"data" : null
} 

2 Edit  PUJA
=====================================
url : /master/puja/<PUJA_ID>
ex url : /master/puja/2

method : PUT
data : 

{
  "name" : "ganesh puja", 
  "description" : "master data description..",
   "price" :"100",
   "duration" : "2 hours",
   "photo" : "c/fileserver/ganesh"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja updated sucessfully/ Failed to update puja"
	"data" : null
} 

3. Get All PUJA
=====================================
url : /master/puja
ex url : /master/puja

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja updated sucessfully/ Failed to update puja"
	"data" : [
		{"id" : 1, "name" : "ganesh puja", "description" : "master data description..","price" :"100","duration" : "2 hours",
   "photo" : "c/fileserver/ganesh"}, {},...
	]
} 

4. Get PUJA
=====================================
url : /master/puja/<PUJA_ID>
ex url : /master/puja/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja updated sucessfully/ Failed to update puja"
	"data" : {"id" : 1, "name" : "ganesh puja", "description" : "master data description..","price" :"100","duration" : "2 hours",
   "photo" : "c/fileserver/ganesh"}
	
} 

5. Delete PUJA
=====================================
url : /master/puja/<PUJA_ID>
ex url : /master/puja/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja deleted sucessfully/ failed to update puja"
	"data" : NULL
	
} 
================================================================================
1. Create PUJA
=====================================
url : /master/puja
ex url : /master/puja
method : POST
data : 

{
  "name" : "coconot", 
  "description" : "master data description..",
   "price" :"100",
   "duration" : "2 hours",
   cou
   "photo" : "c//fileserver/coconut"
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja Created sucessfully/ Failed to create puja"
	"data" : null
} 

2 Edit  PUJA
=====================================
url : /master/puja/<PUJA_ID>
ex url : /master/puja/2

method : PUT
data : 

{
  "name" : "admin", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja updated sucessfully/ Failed to update puja"
	"data" : null
} 

3. Get All PUJA
=====================================
url : /master/puja
ex url : /master/puja

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja updated sucessfully/ Failed to update puja"
	"data" : [
		{"id" : 1, "name" : "admin", "description" : " master data description……"}, {},...
	]
} 

4. Get PUJA
=====================================
url : /master/puja/<PUJA_ID>
ex url : /master/puja/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja updated sucessfully/ Failed to update puja"
	"data" : {"id" : 2, "name" : "admin", "description" : " master data description…"}
	
} 

5. Delete PUJA
=====================================
url : /master/puja/<PUJA_ID>
ex url : /master/puja/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja deleted sucessfully/ failed to update puja"
	"data" : NULL
	
} 
================================================================================
1. Create PUJA_SAMAGRI
=====================================
url : /master/puja_samagri
ex url : /master/puja_samagri
method : POST
data : 

{
  "name" : "coconot", 
  "description" : "master data description..",
   "price" :"100",
   "duration" : "2 hours",
   "photo" : "c//fileserver/coconut"
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja samagri Created sucessfully/ Failed to create puja samagri"
	"data" : null
} 

2 Edit  PUJA_SAMAGRI
=====================================
url : /master/puja_samagri/<PUJA_SAMAGRI_ID>
ex url : /master/puja_samagri/2

method : PUT
data : 

{  "name" : "coconot", 
  "description" : "master data description..",
   "price" :"100",
   "duration" : "2 hours",
   "photo" : "c/fileserver/coconut"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja samagri updated sucessfully/ Failed to update puja samagri"
	"data" : null
} 

3. Get All PUJA_SAMAGRI
=====================================
url : /master/puja_samagri
ex url : /master/puja_samagri

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja samagri updated sucessfully/ Failed to update puja samagri"
	"data" : [
		{"id" : 1 ,"name" : "coconot","description" : "master data description..", "price" :"100", "duration" : "2 hours",
   "photo" : "c/fileserver/coconut"}, {},...
	]
} 

4. Get PUJA_SAMAGRI
=====================================
url : /master/puja_samagri/<PUJA_SAMAGRI_ID>
ex url : /master/puja_samagri/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja samagri updated sucessfully/ Failed to update puja samagri"
	"data" : {"id" : 1 ,"name" : "coconot","description" : "master data description..", "price" :"100", "duration" : "2 hours",
   "photo" : "c/fileserver/coconut"}
	
} 

5. Delete PUJA_SAMAGRI
=====================================
url : /master/puja_samagri/<PUJA_SAMAGRI_ID>
ex url : /master/puja_samagri/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja samagri deleted sucessfully/ failed to update puja samagri"
	"data" : NULL
	
} 
==================================================================================================================

MASTER PUJA_SAMAGRI_PUJAS:
=============

1. Create PUJA_SAMAGRI_PUJA
=====================================
url : /master/puja_samagri_puja
ex url : /master/puja_samagri_puja
method : POST
data : 

{
  "pujasamagri" : "11111", 
  "puja_id" : "23232", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja detals  Created sucessfully/ Failed to create puja detals "
	"data" : null
} 

2 Edit  PUJA_SAMAGRI_PUJA
=====================================
url : /master/puja_samagri_puja/<PUJA_SAMAGRI_PUJA_ID>
ex url : /master/puja_samagri_puja/2

method : PUT
data : 

{
   "pujasamagri" : "11111", 
  "puja_id" : "23232", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja detals  updated sucessfully/ Failed to update puja detals "
	"data" : null
} 

3. Get All role
=====================================
url : /master/puja_samagri_puja
ex url : /master/puja_samagri_puja

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja detals updated sucessfully/ Failed to update puja detals"
	"data" : [
		{"id" : 1,  "pujasamagri" : "11111",  "puja_id" : "23232", }, {},...
	]
} 

4. Get role
=====================================
url : /master/puja_samagri_puja/<PUJA_SAMAGRI_PUJA_ID>
ex url : /master/puja_samagri_puja/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja detals updated sucessfully/ Failed to update puja detals"
	"data" : {"id" : 2, "pujasamagri" : "11111",   "puja_id" : "23232", }
	
} 

5. Delete PUJA_SAMAGRI_PUJA
=====================================
url : /master/puja_samagri_puja/<PUJA_SAMAGRI_PUJA_ID>
ex url : /master/puja_samagri_puja/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "puja detals deleted sucessfully/ failed to update puja detals"
	"data" : NULL
	
} 
========================================================================================

MASTER COUPAN_TYPE:
=============

1. Create COUPAN_TYPE
=====================================
url : /master/coupan_type
ex url : /master/coupan_type
method : POST
data : 

{
  "name" : "reffered", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "coupan type  Created sucessfully/ Failed to create coupan type "
	"data" : null
} 

2 Edit  COUPAN_TYPE
=====================================
url : /master/coupan_type/<COUPAN_TYPE_ID>
ex url : /master/coupan_type/2

method : PUT
data : 

{
  "name" : "reffered", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "coupan type  updated sucessfully/ Failed to update coupan type "
	"data" : null
} 

3. Get All COUPAN_TYPE
=====================================
url : /master/coupan_type
ex url : /master/coupan_type

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "coupan type  updated sucessfully/ Failed to update coupan type "
	"data" : [
		{"id" : 1, "name" : "reffered", "description" : " master data description……"}, {},...
	]
} 

4. Get COUPAN_TYPE
=====================================
url : /master/coupan_type/<COUPAN_TYPE_ID>
ex url : /master/coupan_type/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "coupan type  updated sucessfully/ Failed to update coupan type "
	"data" : {"id" : 2, "name" : "reffered", "description" : " master data description…"}
	
} 

5. Delete COUPAN_TYPE
=====================================
url : /master/coupan_type/<COUPAN_TYPE_ID>
ex url : /master/coupan_type/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "coupan type deleted sucessfully/ failed to update coupan type "
	"data" : NULL
	
} 
========================================================================================