# imgflip-api

## :grey_question: About

This an unofficial API attempt for [Imgflip](https://imgflip.com/). I'm a big fan of Imgflip community and wanted to have a custom and richer API than the official one, also for example, with [Swagger](https://swagger.io/) documentation., the ability to run in as a container, etc...

This API should open a variety of fun usages around Imgflip.

## :rocket: Getting Started

### :computer: Build and run API locally

```
git clone https://github.com/adriens/imgflip-api.git
cd imgflip-api
mvn spring-boot:run
```

:whale: Docker image is coming soon.

## :books: Documentation

### Swagger

Go to <http://localhost:8080/>

## :bookmark_tabs: Endpoint samples

### Meme templates

- `/memes/`
- Get the top `10` meme templates : `/memes/top/10/`
- `/memes/112126428/`

### Published memes

Hot memes : `/hot/{stream}?page=n`

Examples :

- `https://imgflip.com/?page=2`
- `https://imgflip.com/`
- `http://localhost:8080/hot?page=2`
- `http://localhost:8080/hot`
- `http://localhost:8080/hot/politics?page=3`
- `http://localhost:8080/hot/politics`