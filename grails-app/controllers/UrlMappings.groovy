class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/vote"(resources:'vote', includes:['index', 'show', 'save', 'delete', 'update'])
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
