
//script para testes de requisição

fetch('http://127.0.0.1:8766/loja/itens?page=1&size=5',{ method: 'GET' })
	.then(resp=>{
		
		if(resp.status === 200){
			
			resp.json().then(resp=>{
				
				if(resp.length === 0 ){
					
					alert("fim da página")
					
				}else{
					
					console.log(resp)
					
				}
			
			})
		
		}else{
			
			throw 'xi deu ruim'
			
		}
		
	})
	.catch(err=>console.log(err))



/* 
 * use o metodo abaixo para limpar o console do browser
 * 
 * 		clear() 
 * 
 * 
 */*/ 