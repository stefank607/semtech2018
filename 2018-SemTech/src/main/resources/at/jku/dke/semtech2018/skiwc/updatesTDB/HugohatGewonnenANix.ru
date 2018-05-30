PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
PREFIX : <http://example.org/> 
PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> 
INSERT DATA { 
	:ANix a :Weltcup. }; 
INSERT DATA { 
	:Hugo  a :Skifahrer. 
};
INSERT DATA { 
	:Hugo :hatGewonnen :ANix
};