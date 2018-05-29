PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
PREFIX : <http://example.org/> 
PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> 
INSERT DATA { 
	:SlalomWeltcup2017 a :Weltcup. }; 
INSERT DATA { 
	:MarcelHirscher  a :Skifahrer. 
};
INSERT DATA { 
	:MarcelHirscher :hatGewonnen :SlalomWeltcup2017
};