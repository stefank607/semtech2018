PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
PREFIX : <http://example.org/> 
PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> 
INSERT DATA { 
	:Nix a :Weltcup. }; 
INSERT DATA { 
	:Testeintrag  a :Skifahrer. 
};
INSERT DATA { 
	:Testeintrag :hatGewonnen :Nix
};