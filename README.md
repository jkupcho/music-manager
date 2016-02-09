fetch('http://localhost:8080/api/artists', {
  method: 'post',
  credentials: 'include',
  body: JSON.stringify({ name: 'Some Artist' }),
  headers: {
    'Content-Type': 'application/json'
  }
})