import React from "react";
import { FaHome, FaFire, FaGamepad, FaFilm, FaBook } from "react-icons/fa";

const Sidebar = () => {
  return (
    <aside className="hidden md:block w-60 text-sm text-gray-300">
      <div className="sticky top-6 space-y-4">
        <div>
          <p className="text-xs uppercase mb-2 text-gray-500">Inicio</p>
          <div className="space-y-2">
            <button className="flex items-center gap-2 hover:text-white">
              <FaHome /> Inicio
            </button>
            <button className="flex items-center gap-2 hover:text-white">
              <FaFire /> Popular
            </button>
          </div>
        </div>
        <div>
          <p className="text-xs uppercase mb-2 text-gray-500">Temas</p>
          <div className="space-y-2">
            <button className="flex items-center gap-2 hover:text-white">
              <FaGamepad /> Juegos
            </button>
            <button className="flex items-center gap-2 hover:text-white">
              <FaFilm /> Películas y TV
            </button>
            <button className="flex items-center gap-2 hover:text-white">
              <FaBook /> Cultura
            </button>
          </div>
        </div>
      </div>
    </aside>
  );
};

export default Sidebar;