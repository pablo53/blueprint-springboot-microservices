db.createUser({
    user: "usvc",
    pwd: "usvc123",
    roles: [
        { role: "readWrite", db: "usvcdb" }
    ]
});
