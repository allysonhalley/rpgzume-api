package com.hefti

class UrlMappings {
    static mappings = {
        // Rotas RESTful para Card, Feature e Magic
        "/cards"(resources: "card")
        "/features"(resources: "feature")
        "/magics"(resources: "magic")

        // Rota dinâmica padrão
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        // Página inicial
        "/"(view:"/index")

        // Tratamento de erros
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
