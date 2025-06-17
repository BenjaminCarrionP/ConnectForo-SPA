// src/components/Navbar.jsx

import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Search, User } from 'lucide-react';

const Navbar = () => {
  const [search, setSearch] = useState('');
  const [placeholder, setPlaceholder] = useState('Buscar en ConnectForo');

  const handleChange = (e) => {
    const v = e.target.value;
    setSearch(v);
    if (v.length === 1) {
      setPlaceholder('');
    }
  };

  const handleBlur = () => {
    if (!search) {
      setPlaceholder('Buscar en ConnectForo');
    }
  };

  return (
    <nav className="sticky top-0 z-50 bg-neutral-900 border-b border-neutral-700">
      <div className="max-w-7xl mx-auto flex items-center px-4 py-2 space-x-4">
        {/* Logo a la izquierda */}
        <Link to="/" className="text-xl font-bold text-green-500">
          ConnectForo
        </Link>

        {/* Barra de búsqueda */}
        <div className="flex-1 relative">
          <span className="absolute inset-y-0 left-3 flex items-center text-gray-400">
            <Search size={16} />
          </span>
          <input
            type="text"
            value={search}
            onChange={handleChange}
            onBlur={handleBlur}
            placeholder={placeholder}
            className="w-full bg-neutral-800 text-white placeholder-gray-400 rounded-full pl-10 pr-4 py-1 focus:outline-none focus:ring-2 focus:ring-green-500"
          />
        </div>

        {/* Botón de sesión / icono de perfil */}
        <div className="flex items-center space-x-3">
          {/* Muestra este botón cuando no hay sesión iniciada */}
          <button className="bg-green-600 text-white px-4 py-1 rounded hover:bg-green-700">
            Iniciar Sesión
          </button>

          {/* Cuando el usuario esté logueado podrías renderizar esto en su lugar */}
          {/*
          <button>
            <User size={20} className="text-white" />
          </button>
          */}
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
