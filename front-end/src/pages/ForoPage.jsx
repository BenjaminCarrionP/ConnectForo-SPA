// src/pages/ForoPage.jsx

import React, { useState } from "react";
import { useParams } from "react-router-dom";
import Sidebar from "../components/Sidebar";
import SidebarDerecho from "../components/SidebarDerecho";
import ForoCard from "../components/ForoCard";
import Footer from "../components/Footer";

const ForoPage = () => {
  const { id } = useParams();

  // Mock de datos del foro
  const [foro] = useState({
    id: parseInt(id, 10),
    name: `Foro #${id}`,
    icon: "/icons/general.png",
    description: "Descripción breve del foro seleccionado."
  });

  // Mock de publicaciones para este foro
  const [publications] = useState([
    {
      id: foro.id * 100 + 1,
      foroId: foro.id,
      title: "Título de la publicación A",
      imageUrl: "/imgs/placeholder.jpg",
      content: "Contenido de ejemplo A…",
      upvotes: 12,
      downvotes: 1,
      comments: 4
    },
    {
      id: foro.id * 100 + 2,
      foroId: foro.id,
      title: "Título de la publicación B",
      imageUrl: "/imgs/placeholder.jpg",
      content: "Contenido de ejemplo B…",
      upvotes: 8,
      downvotes: 0,
      comments: 2
    },
    // …añade más mocks si quieres
  ]);

  return (
    <div className="min-h-screen bg-neutral-900 text-white">
      {/* Header del foro */}
      <div className="px-4 py-6">
        <div className="flex items-center space-x-3 mb-2">
          <img
            src={foro.icon}
            alt={foro.name}
            className="h-8 w-8 rounded-full"
          />
          <h1 className="text-3xl font-bold">{foro.name}</h1>
        </div>
        <p className="mb-6 text-gray-300">{foro.description}</p>

        <div className="flex px-4 gap-6">
          {/* Sidebar izquierdo */}
          <Sidebar />

          {/* Listado de publicaciones */}
          <main className="flex-1 space-y-6">
            {publications.map(pub => (
              <ForoCard
                key={pub.id}
                foro={foro}
                publication={pub}
              />
            ))}
          </main>

          {/* Sidebar derecho + Footer */}
          <aside className="w-64 sticky top-24 flex flex-col gap-6">
            <SidebarDerecho />
            <Footer />
          </aside>
        </div>
      </div>
    </div>
  );
};

export default ForoPage;
