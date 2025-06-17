import React from "react";

const SidebarDerecho = () => {
  return (
    <div className="bg-neutral-800 p-4 rounded-xl">
      <h3 className="text-white font-bold mb-3">Comunidades populares</h3>
      <ul className="space-y-2 text-gray-300">
        <li><a href="/r/Anime" className="hover:underline">r/Anime</a></li>
        <li><a href="/r/Juegos" className="hover:underline">r/Juegos</a></li>
        <li><a href="/r/Memes" className="hover:underline">r/Memes</a></li>
        <li><a href="/r/Programacion" className="hover:underline">r/Programación</a></li>
        <li><a href="/r/CulturaChilena" className="hover:underline">r/CulturaChilena</a></li>
      </ul>
    </div>
  );
};

export default SidebarDerecho;