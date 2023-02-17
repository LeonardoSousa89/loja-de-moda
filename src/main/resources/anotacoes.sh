# arquivo de CorsConfig elemento de tipo: CorsConfigurationSource
 
# exemplo de permissão de url única
	# configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:4200"));
	# configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:5500"));

# exemplo de permissão de url composta
	# configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:5500", "http://127.0.0.1:4200", "http://127.0.0.1:3000"));

# exemplo de permissão geral
# configuration.setAllowedOrigins(Arrays.asList("*"));