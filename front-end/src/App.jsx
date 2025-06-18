// src/App.jsx

import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Home from './pages/Home';
import ForoPage from './pages/ForoPage';
import PostPage from './pages/PostPage';

function App() {
  return (
    <>
      {/* Navbar siempre arriba */}
      <Navbar />

      {/* Aquí ya no envolvemos en <Router>, sólo definimos rutas */}
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/foro/:id" element={<ForoPage />} />
        <Route path="/post/:id" element={<PostPage />} />
      </Routes>
    </>
  );
}

export default App;
