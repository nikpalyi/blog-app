# Super Simple Blog application
Blog app in Scala and Akka

## Current file structure:
```
├── LICENSE
├── README.md
├── build.sbt
├── project
│   ├── build.properties
...
├── src
│   ├── main
│   │   ├── scala
│   │   │   ├── BlogEngine.scala
│   │   │   ├── controllers
│   │   │   │   └── BlogController.scala
│   │   │   └── src
│   │   │       └── main
│   │   └── views
│   │       └── template
│   │           └── index.html
│   └── test
│       └── scala
│           └── MySuite.scala
```

## How to run this app:
Clone or download this repo:
```
git clone https://github.com/nikpalyi/blog-app.git
```
After cloning or download, run:
```
cd blog-app
```
OR
```
cd blog-app-master
```
Run:
```
sbt compile
```

Run:
```
sbt run
```

You should get a logging output as:
```
"[info] done compiling
[info] running BlogApp 
Server online at http://localhost:8080/
Press RETURN to stop..."
```
And you can go to: http://localhost:8080/ in your browser

### Plan:

TBD

### TODO Checklist:
- [ ] Testing
- [ ] Refactoring
- [ ] ... 

### Additional feature ideas for nice to have future:

- User authentication and authorization:  allow users to sign up, log in, and log out of the application. You can also restrict access to certain pages or actions based on the user's role (e.g. admin, author, reader).

- Comment system:  allow users to leave comments on blog posts. You can implement moderation controls to approve or reject comments.

- Categories and tags:  allow users to categorize their blog posts into different categories and add tags to make it easier for readers to find related content.

- Image and media uploads:  allow users to upload images and other media files to accompany their blog posts.

- Search and filtering:  implement a search bar that allows users to search for specific posts based on keywords, categories, tags, author, etc. You can also implement filtering options to allow users to sort posts by date, popularity, etc.

- Email notifications:  send email notifications to users when new posts are published, comments are added, etc.

- Social sharing: can add social sharing buttons to allow users to share blog posts on social media platforms.

- Responsive design: make the blog application responsive so that it looks good on different devices and screen sizes.