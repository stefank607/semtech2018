PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
PREFIX : <http://example.org/> 
PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> 
INSERT DATA { 
	:WeltcupRiesenslalom1977 a :Weltcup. }; 
INSERT DATA { 
	:HansiHinterseer  a :Skifahrer. 
};
INSERT DATA { 
	:HansiHinterseer :hatGewonnen :WeltcupRiesenslalom1977
};