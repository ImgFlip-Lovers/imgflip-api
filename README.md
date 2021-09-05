# imgflip-api

## :grey_question: About

This an unofficial API attempt for [Imgflip](https://imgflip.com/). I'm a big fan of Imgflip community and wanted to have a custom and richer API than the official one, also for example, with [Swagger](https://swagger.io/) documentation., the ability to run in as a container, etc...

This API should open a variety of fun usages around Imgflip.

## :rocket: Getting Started

```sh
git clone https://github.com/adriens/imgflip-api.git
cd imgflip-api
```

### Build and run API locally

```sh
mvn spring-boot:run
```

### Using docker

:whale: Docker image _(on [dockerhub](https://hub.docker.com/))_ is coming soon.

#### Build image locally

We use the :building_construction: [jib](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin) maven plugin from Google [GoogleContainerTools/jib](https://github.com/GoogleContainerTools/jib) to build the base image.

```sh
mvn compile jib:dockerBuild
```

#### Run it

```sh
docker run -p 8080:8080 --name imgflip-api imgflip-lovers/imgflip-api
```

## :books: Documentation

### Swagger

Go to <http://localhost:8080/>

### ReDoc

Do you know [ReDoc](https://github.com/Redocly/redoc) ? Try it out now!

#### Html file

First, launch the api. Create a `html` file with the below content and open it : 

```html
<!DOCTYPE html>
<html>
    <head>
        <title>ReDoc</title>
        <!-- needed for adaptive design -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700|Roboto:300,400,700" rel="stylesheet">

        <!--
        ReDoc doesn't change outer page styles
        -->
        <style>
            body {
            margin: 0;
            padding: 0;
            }
        </style>
    </head>
    <body>
        <redoc spec-url="http://localhost:8080/v3/api-docs"></redoc>
        <script src="https://cdn.jsdelivr.net/npm/redoc/bundles/redoc.standalone.js"></script>
    </body>
</html>
```

#### Docker-compose

> the docker image api is required and can be built by `mvn compile jib:dockerBuild`

Run the containers using `docker-compose` CLI : 

```sh
docker-compose --project-name imgflip -f .\docker-compose.yml up -d
```

Go to <http://localhost:8081/>

To stop and uninstall :

```sh
docker-compose --project-name imgflip -f .\docker-compose.yml down
```

## :bookmark_tabs: Endpoint samples

### Meme templates

* Memes :  `http://localhost:8080/memes`

```sh
$ http :8080/memes/
HTTP/1.1 200
Content-Type: application/json

[
    {
        "box_count": 2,
        "height": 1200,
        "id": 181913649,
        "name": "Drake Hotline Bling",
        "url": "https://i.imgflip.com/30b1gx.jpg",
        "width": 1200
    },
    ...
]
```

* Get the top `10` meme templates : `http://localhost:8080/memes/top/10/`

```sh
$ http :8080/memes/top/3
HTTP/1.1 200
Content-Type: application/json

[
    {
        "box_count": 2,
        "height": 1200,
        "id": 181913649,
        "name": "Drake Hotline Bling",
        "url": "https://i.imgflip.com/30b1gx.jpg",
        "width": 1200
    },
    {
        "box_count": 3,
        "height": 908,
        "id": 87743020,
        "name": "Two Buttons",
        "url": "https://i.imgflip.com/1g8my4.jpg",
        "width": 600
    },
    {
        "box_count": 3,
        "height": 800,
        "id": 112126428,
        "name": "Distracted Boyfriend",
        "url": "https://i.imgflip.com/1ur9b0.jpg",
        "width": 1200
    }
]
```

- Get Meme by ID : `http://localhost:8080/memes/112126428/`

```sh
$ http :8080/memes/112126428
HTTP/1.1 200
Content-Type: application/json

{
    "box_count": 3,
    "height": 800,
    "id": 112126428,
    "name": "Distracted Boyfriend",
    "url": "https://i.imgflip.com/1ur9b0.jpg",
    "width": 1200
}
```

### Published memes

* Get hot politics memes : `http://localhost:8080/hot/politics?page=2`

```sh
$ http :8080/hot/gaming?page=2
HTTP/1.1 200
Content-Type: application/json

[
    {
        "author": "VinceVance",
        "authorPath": "/user/VinceVance",
        "imageUrl": "https://i.imgflip.com/5jbb6n.jpg",
        "memeUrl": "https://imgflip.com/i/5jbb6n",
        "mp4Url": null,
        "posterUrl": null,
        "rawScore": null,
        "score": {
            "nbComments": 3,
            "nbUpvotes": 38,
            "nbViews": 378
        },
        "title": "The millions we make here in the USA isn't enough...",
        "webmUrl": null
    },
    ...
]
```