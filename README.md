fetch('http://localhost:8080/api/artists', {
  method: 'post',
  credentials: 'include',
  body: JSON.stringify({ name: 'Some Artist' }),
  headers: {
    'Content-Type': 'application/json'
  }
})

fetch('http://localhost:8080/api/siteUsers', {
  method: 'post',
  credentials: 'include',
  body: JSON.stringify({ username: 'register', password: 'now' }),
  headers: {
    'Content-Type': 'application/json'
  }
})