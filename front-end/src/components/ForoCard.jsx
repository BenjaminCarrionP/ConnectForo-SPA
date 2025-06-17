// src/components/ForoCard.jsx

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  ArrowUp,
  ArrowDown,
  MessageCircle,
  Award,
  MoreHorizontal
} from 'lucide-react';

const ForoCard = ({ foro, publication }) => {
  const navigate = useNavigate();
  const [menu, setMenu] = useState(false);

  return (
    <div className="bg-neutral-800 border border-neutral-700 rounded-lg shadow p-4 text-white">
      <div className="flex items-center justify-between">
        <div
          className="flex items-center space-x-2 cursor-pointer"
          onClick={() => navigate(`/foro/${foro.id}`)}
        >
          <img src={foro.icon} alt={foro.name} className="h-6 w-6 rounded-full" />
          <span className="text-sm font-medium hover:text-gray-200">
            {foro.name}
          </span>
        </div>

        <button
          onClick={e => e.stopPropagation()}
          className="text-sm bg-blue-600 px-3 py-1 rounded hover:bg-blue-700"
        >
          Únete
        </button>

        <div className="relative">
          <button
            onClick={() => setMenu(v => !v)}
            className="p-2 rounded-full hover:bg-neutral-700"
          >
            <MoreHorizontal className="text-gray-400" size={20} />
          </button>
          {menu && (
            <div className="absolute right-0 mt-2 w-44 bg-neutral-800 border border-neutral-700 rounded shadow-lg z-10">
              <button className="w-full px-4 py-2 text-left hover:bg-neutral-700 text-sm">
                Enviar comentarios
              </button>
              <button className="w-full px-4 py-2 text-left hover:bg-neutral-700 text-sm">
                Reportar
              </button>
            </div>
          )}
        </div>
      </div>

      {publication.imageUrl && (
        <div className="mt-4">
          <img
            src={publication.imageUrl}
            alt={publication.title}
            className="w-full object-cover rounded"
          />
        </div>
      )}

      <h2 className="mt-2 text-lg font-semibold">{publication.title}</h2>

      <div className="mt-4 flex items-center space-x-6 text-gray-400">
        <button className="flex items-center space-x-1 hover:text-green-400">
          <ArrowUp size={16} />
          <span>{publication.upvotes}</span>
        </button>
        <button className="flex items-center space-x-1 hover:text-red-400">
          <ArrowDown size={16} />
          <span>{publication.downvotes}</span>
        </button>
        <button
          onClick={() => navigate(`/post/${publication.id}`)}
          className="flex items-center space-x-1 hover:text-blue-400"
        >
          <MessageCircle size={16} />
          <span>{publication.comments}</span>
        </button>
        <button className="flex items-center space-x-1 hover:text-yellow-400">
          <Award size={16} />
          <span>Premiar</span>
        </button>
      </div>
    </div>
  );
};

export default ForoCard;
