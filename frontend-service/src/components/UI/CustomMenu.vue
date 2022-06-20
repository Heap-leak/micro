<template>
  <body class="custom__menu">
      <ul>
          <li style="--i:6;"><a href="/">Home</a></li>
          <li style="--i:5;"><a href="/about">About</a></li>
          <li style="--i:4;"><a href="/posts">Posts</a></li>
          <li style="--i:3;"><a href="http://localhost:8001">Services</a></li>
          <li style="--i:2;"><a href="a">Architecture</a></li>
          <li style="--i:1;"><a href="a">Contact</a></li>
      </ul>
  </body>
</template>

<script>
export default {

}
</script>



<style>

* {
  margin: 0;
  padding: 0px;
  box-sizing: border-box;
  font-family: monospace;
}

body {
  display: flex;
  justify-content: left;
  padding: 25px 7px;
  min-height: 45vh;
  background: #434750;
}

ul {
  position: relative;
  transform: skewY(-15deg);
}

ul li {
  position: relative;
  list-style: none;
  width: 120px;
  background: #3e3f46;
  padding: 15px;
  z-index: var(--i);
  transition: 0.5s;

}

ul li:hover {
  background: #15c023;
  transform: translateX(50px);
}

ul li::before {
  content: '';
  position: absolute;
  top: 0;
  left: -40px;
  width: 40px;
  height: 100%;
  background: #2e3133;
  transform-origin: right;
  transform: skewY(45deg);
  transition: 0.5s;
}

ul li:hover::before {
  background: #185f24;
}

ul li::after {
  content: '';
  position: absolute;
  top: -40px;
  left: 0;
  width: 100%;
  height: 40px;
  background: #34383e;
  transform-origin: bottom;
  transform: skewX(45deg);
  transition: 0.5s;
}

ul li:hover::after {
  background: #258d36;
}

ul li a {
  text-decoration: none;
  color: #999;
  display: block;
  text-transform: uppercase;
  letter-spacing: 0.05em;
  transition: 0.5s;
}

ul li:hover a {
  color: #fff;
}

ul li:last-child::after {
  box-shadow: -120px 120px 20px rgba(0, 0, 0, 0.25);
}
</style>